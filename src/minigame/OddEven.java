package minigame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//���� ���� �ʰ� �ⱸ�� ĳ���͸� Ż���Ű�� ����
public class OddEven extends MiniGame{
	private JButton odd, even;
	private JPanel player_panel;
	private JLabel computer_label;
	private int player, computer;
	public ResultDialog resultdialog;
	
	public OddEven(){

		resultdialog = new ResultDialog(this);
	}
	
	@Override
	public void run() {
		setTitle("OddEven");
		this.init(); //ȭ�� ����
		this.start(); //�̺�Ʈ, ���� ó��
		this.setBounds(500, 100, 600, 600); //ȭ��ũ��
		this.setResizable(false);
		setVisible(true);
	}
	
	@Override
	protected void init() {
		//��ǻ�Ϳ� �̹��� �߰�
		ImageIcon computer_icon = new ImageIcon("images/question.png");
		computer_icon = ImageSetSize(computer_icon, 250 ,250);
		computer_label = new JLabel(computer_icon);
		
		//�÷��̾�� ��ư �߰�
		ImageIcon odd_icon = new ImageIcon("images/odd.png");
		odd_icon = ImageSetSize(odd_icon, 250 ,250);
		odd = new JButton();
		odd.setIcon(odd_icon);
//		odd.setBackground(new Color(255, 255, 255));
		
		ImageIcon even_icon = new ImageIcon("images/even.png");
		even_icon = ImageSetSize(even_icon, 250 ,250);
		even = new JButton();
		even.setIcon(even_icon);
//		even.setBackground(new Color(255, 255, 255));
		
		player_panel = new JPanel();
		player_panel.setLayout(new GridLayout(1, 2));
		player_panel.add(odd);
		player_panel.add(even);
		
		setLayout(new GridLayout(2, 1));
		add(computer_label);
		add(player_panel);
	
	}
	
	@Override
	protected void start() {
		ActionListener buttonlistener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//player ����
				//odd
				if(e.getSource().equals(odd)) {
					odd.setBackground(new Color(255, 0, 0));
					even.setEnabled(false);
					player = 1;
				}
				else { //even
					even.setBackground(new Color(255, 0, 0));
					odd.setEnabled(false);
					player = 0;
				}
				
				//computer
				Random r = new Random();
				computer = r.nextInt(2);
				if(computer == 1) {
					computer_label.setIcon(odd.getIcon());
				}else{
					computer_label.setIcon(even.getIcon());
				}
				
				//view result
				resultdialog.setResult(getResult());
				resultdialog.setVisible(true);
			}
		};
		odd.addActionListener(buttonlistener);
		even.addActionListener(buttonlistener);
	}
			
	@Override
	public int getResult() {
		if(computer==player) {
			return 1;
		}
		return 0;
	}
	@Override
	public ResultDialog getResultDialog() {
		return this.resultdialog;
	}
}