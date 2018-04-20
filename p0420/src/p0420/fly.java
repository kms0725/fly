package p0420;

import java.awt.*;
import java.awt.event.*;

public class fly extends Frame implements ActionListener {
	Label lbl1, lbl2;
	TextField tf;
	CheckboxGroup cg;
	Checkbox cb1, cb2;
	Choice ch;
	List li;
	TextArea ta;
	Button bt1, bt2; // 닫기 버튼을 눌렀을 때 화면을 닫는다. 
	public fly() { 
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0); 
				} 
			}); 
		lbl1 = new Label("이 름 : ");
		lbl2 = new Label("성 별 : ");
		tf = new TextField(8);
		cg = new CheckboxGroup();
		cb1 = new Checkbox("남", cg, false);
		cb2 = new Checkbox("여", cg, false); 
		ch = new Choice(); 
		ch.addItem("KAL"); 
		ch.addItem("ASIANA");
		ch.addItem("USA"); li = new List(4, false); 
		li.add("SEOUL"); 
		li.add("TOKYO");
		li.add("NEWYOUK"); 
		li.add("AFRICA"); 
		li.select(0); 
		ta = new TextArea("", 50, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		bt1 = new Button("예약"); 
		bt2 = new Button("취소"); 
		bt1.addActionListener(this); 
		bt2.addActionListener(this);
		Panel pn1 = new Panel();
		pn1.add(lbl1);
		pn1.add(tf);
		pn1.add(lbl2);
		pn1.add(cb1);
		pn1.add(cb2);
		pn1.add(ch); 
		pn1.add(li); 
		Panel pn2 = new Panel();
		pn2.add(bt1); 
		pn2.add(bt2); 
		pn2.add(bt1); 
		pn2.add(bt2); 
		add("North", pn1);
		add("Center", ta);
		add("South", pn2); } // 프레임 세팅
	public static void main(String[] args) {
		fly f = new fly(); 
		f.setTitle("항공기 예약 프로그램");
		f.setSize(600, 300); 
		f.setVisible(true); 
		} // 액션이벤트 처리
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource(); 
			String sex = new String(); 
			String airsupport = new String();
			if((Button)obj == bt1) {
				 if(cb1.getState()) sex = "남"; 
				 if(cb2.getState()) sex = "여";
				 if(ch.getSelectedItem() == "KAL") airsupport = "대한"; 
				 if(ch.getSelectedItem() == "ASIANA") airsupport = "아시아나"; 
				 if(ch.getSelectedItem() == "USA") airsupport = "미국"; 
				 ta.setText(tf.getText()+"님은 "+ sex + "자 이시고, " + airsupport + "항공 "+ li.getSelectedItem()+ "편을 예약하셨습니다.");
				 } else {
						 ta.setText("다시 입력해주세요");
						 } 
			} 
		}
