package com.biz.files.service;

public class GradeExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		GradeService gs = new GradeService("src/com/biz/files/service/우리말이름.txt");
		
		gs.readFile();
		gs.makeNum();
		gs.addNum();
		gs.makeScore();
		gs.view();
		
		
	}

}
