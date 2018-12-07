package com.biz.files.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.biz.files.vo.GradeVO;

public class GradeService {

	List<GradeVO> gradeList;
	String strFileName;
	List<String> strNumList;

	public GradeService(String strFileName) {
		gradeList = new ArrayList();
		this.strFileName = strFileName;
		strNumList = new ArrayList();
	}

	public void readFile() {
		FileReader fr;
		BufferedReader buffer;

		try {
			fr = new FileReader(strFileName);
			buffer = new BufferedReader(fr);

			while (true) {

				String strWord = buffer.readLine();
				if (strWord == null)
					break;

				String[] splWord = strWord.split(":");
				GradeVO vo = new GradeVO();
				vo.setStrName(splWord[0]);
				gradeList.add(vo);

			}
			
			buffer.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void makeNum() {
		int intSz = gradeList.size();
		for (int i = 0; i < intSz; i++) {
			int intNum = i + 1 ;
			strNumList.add("" + intNum);
		}
		// List<String> strNumList 에 담긴 학번은
		// 현재 정렬이 된 상태이나
		// 만약 정될되지 않고, 중복 값이 있다고 하면
	}
	public void addNum() {
		
		int intsz = strNumList.size();
		for(int i = 0 ; i < intsz ; i++) {
			
	    GradeVO vo = gradeList.get(i);
		vo.setStrNum(strNumList.get(i));
		
		
		}
	}
	public void makeScore() {
		int intSz = gradeList.size();
		for(int i = 0 ; i < intSz ; i++) {
			GradeVO vo = gradeList.get(i);
			vo.setIntKor((int)(Math.random() * (100 - 50 + 1) + 50));
			vo.setIntEng((int)(Math.random() * (100 - 50 + 1) + 50));
			vo.setIntMath((int)(Math.random() * (100 - 50 + 1) + 50));
			vo.setIntSum( vo.getIntKor() 
					    + vo.getIntEng()
					    + vo.getIntMath());
			vo.setFloatAvg( vo.getIntSum() / 3 );
		}
	}
	public void view() {
		
		System.out.println("====================================================================");
		System.out.println("학번\t이름\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("--------------------------------------------------------------------");
		
		for(GradeVO s : gradeList) {
			
			System.out.print(s.getStrNum() + "\t");
			System.out.print(s.getStrName() + "\t" + "\t");
			System.out.print(s.getIntKor() + "\t");
			System.out.print(s.getIntEng() + "\t");
			System.out.print(s.getIntMath() + "\t");
			System.out.print(s.getIntSum() + "\t");
			System.out.print(s.getFloatAvg() + "\n");
		}
	}
}
