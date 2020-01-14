package jp.ac.uryukyu.ie.e195705;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {
    int count = 0;
    String input;//userが入力した文字列を保存する
    String word_end;//userが入力した文字列の末尾1文字を保存する
    String word_initial;//computerが出力した時の頭1文字を保存する

    @org.junit.jupiter.api.Test
    void action() {
        String input = "マカオ";
        String word_end;
        word_end = input.substring(input.length() -1);
        assertEquals(input.substring(input.length() -1),word_end);//適当に末尾1文字が抜き出せているか
    }
}