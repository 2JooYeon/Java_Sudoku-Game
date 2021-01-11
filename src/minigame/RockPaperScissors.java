package minigame;

import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RockPaperScissors extends MiniGame{
	private JButton rock, paper, scissor;
	private JPanel player_panel;
	private JLabel computer_label, info;
	private int player, computer;
	private String name;
	public ResultDialog resultdialog;
	
	public RockPaperScissors() {
		resultdialog = new ResultDialog(this);
	}
	
	@Override
	public void run() {
		setTitle("RockPaperScissor");
		this.init(); //ȭ�� ����
		this.start(); //�̺�Ʈ, ���� ó��
		this.setBounds(500, 100, 600, 800); //ȭ��ũ��
		this.setResizable(false);
		setVisible(true);
	}
	
	@Override
	protected void init() {
		//information
		info = new JLabel("<html>����������<br>" + "�̰��� ��쿡�� ���� �ϳ� ����.<br><html>");
		info.setFont(new Font("Serif", Font.BOLD, 20));
		info.setHorizontalAlignment(JLabel.CENTER);
		
		//��ǻ�Ϳ� �̹��� �߰�
		ImageIcon computer_icon = new ImageIcon("images/question.png");
		computer_icon = ImageSetSize(computer_icon, 250 ,250);
		computer_label = new JLabel(computer_icon);
		
		rock = new JButton();
		ImageIcon rock_icon = new ImageIcon("images/rock.jpg");
		rock_icon = ImageSetSize(rock_icon, 180, 180);
		rock.setIcon(rock_icon);
		rock.setBackground(new Color(255, 255, 255));
		
		paper = new JButton();
		ImageIcon paper_icon = new ImageIcon("images/paper.jpg");
		paper_icon = ImageSetSize(paper_icon, 180, 180);
		paper.setIcon(paper_icon);
		paper.setBackground(new Color(255, 255, 255));
		
		scissor = new JButton();
		ImageIcon scissor_icon = new ImageIcon("images/scissor.jpg");
		scissor_icon = ImageSetSize(scissor_icon, 180, 180);
		scissor.setIcon(scissor_icon);
		scissor.setBackground(new Color(255, 255, 255));
		
		//�÷��̾�� ��ư �߰�
		player_panel = new JPanel();
		player_panel.setLayout(new GridLayout(1, 3, 0, 5));
		player_panel.add(rock);
		player_panel.add(paper);
		player_panel.add(scissor);
		
		setLayout(new BorderLayout());
		add(info, BorderLayout.NORTH);
		add(computer_label, BorderLayout.CENTER);
		add(player_panel, BorderLayout.SOUTH);
		
	}
	
	@Override 
	protected void start() {
		ActionListener buttonlistener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//player ����
				//Rock
				if(e.getSource().equals(rock)) {
					rock.setBackground(new Color(255, 0, 0));
					paper.setEnabled(false);
					scissor.setEnabled(false);
					player = 0;
				}
				//Paper
				else if(e.getSource().equals(paper)) {
					paper.setBackground(new Color(255, 0, 0));
					rock.setEnabled(false);
					scissor.setEnabled(false);
					player = 1;
				}
				//Scissor
				else {
					scissor.setBackground(new Color(255, 0, 0));
					rock.setEnabled(false);
					paper.setEnabled(false);
					player = 2;
				}
				
				//���� ��ǻ�� ����
	            Random r = new Random();
	            computer = r.nextInt(3);
	            switch(computer) {
	            case 0:      
	               computer_label.setIcon(rock.getIcon());
	               break;      
	            case 1:      
	               computer_label.setIcon(paper.getIcon());
	               break;
	            case 2:
	               computer_label.setIcon(scissor.getIcon());
	               break;
	            }
	            
	            //���� ���
	            //view result
	            resultdialog.setResult(getResult());
	            resultdialog.setVisible(true);
	         }
	      };
	      
	      rock.addActionListener(buttonlistener);
	      paper.addActionListener(buttonlistener);
	      scissor.addActionListener(buttonlistener);
	      
	      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	   }
	   
	   @Override
	   public int getResult() {
	      //0:�ָ� 1:�� 2: ����
	      //user���������� ��� 0: fail, 1: win, 2:draw
	      int[][] result_str = {
	            {2, 0, 1}, //user: �ָ�
	            {1, 2, 0}, //user: ��
	            {0, 1, 2} //user: ����
	      };
	      return result_str[this.player][this.computer];
	   }
	
	@Override
	public ResultDialog getResultDialog() {
		return this.resultdialog;
	}
}


