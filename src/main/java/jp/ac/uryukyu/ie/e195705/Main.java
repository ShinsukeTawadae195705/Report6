package jp.ac.uryukyu.ie.e195705;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;//これが標準出力（応答文）をするために必要

abstract class Character{
    String name;
    Character(String name){
        this.name = name;
    }
}

class words {
    //効率よくしりとりを行いたいため全てをカタカナで表記した。わかりにくい場合は()を用いて表記した。
    List<String> words_A = new ArrayList<>(Arrays.asList("アルキメデス", "インテグラル", "ウ（裏）ラ", "エピサイクロイド", "オイラー"));
    List<String> words_K = new ArrayList<>(Arrays.asList("カクリツブン（確率分布）プ", "キョス（虚数）ウ", "クラインノツ（クラインの壺）ボ", "ケーニヒスベルグ", "コセカント"));
    List<String> words_S = new ArrayList<>(Arrays.asList("サイクロイド", "シゼンタイス（自然対数）ウ", "スーパーソス（スーパー素数）ウ", "セイキブン（正規分布）プ", "ソインスウブンカ（素因数分解）イ"));
    List<String> words_T = new ArrayList<>(Arrays.asList("タンジェント", "チャンパーノウンテイス（チャンパーノウン定数）ウ", "ツェラーノコウシ（ツェラーの公式）キ", "テイラーテンカ（テイラー展開）イ", "トクセイホウテイシ（特性方程式）キ"));
    List<String> words_N = new ArrayList<>(Arrays.asList("ナン（NAND）ド", "ニコウケイス（二項係数）ウ", "", "ネイピアス（ネイピア数）ウ", "ノウ（濃度）ド"));
    List<String> words_H = new ArrayList<>(Arrays.asList("ハミルトンサイクル", "ヒルベルトホテル", "フィボナッチスウレ（フィボナッチ数列）ツ", "ヘロンノコウシ（ヘロンの公式）キ", "ホシュウゴ（補集合）う"));
    List<String> words_M = new ArrayList<>(Arrays.asList("マンデルブロシュウゴ（マンデルブロ集合）ウ", "ミチス（未知数）ウ", "ムゲンダ（無限大）イ", "メルセンヌ", "モンテカルロホ（モンテカルロ法）ウ"));
    List<String> words_Y = new ArrayList<>(Arrays.asList("ヤコビギョウレ（ヤコビ行列）ツ", "ユークリッド", "ヨゲンテイ（余弦定理）リ"));
    List<String> words_R = new ArrayList<>(Arrays.asList("ライプニッツ", "リシンリ（離心率）ツ", "ルーローノサンカッケ（ルーローの三角形）イ", "レーダーチャート", "ロンリエンザン（論理演算子）シ"));
}

class Player extends Character{
    String word_end;
    String pattern = "^[\\u3040-\\u309F]+$";
    Player(String name) {
        super(name);
    }

    public void Action(){
        System.out.println(this.name+"のターン");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();//String型の文字列を入力したいからnextLine()を用いる
        word_end = input;
        if(word_end.equals(pattern)){

        }

    }
}

class Computer extends Character{
    Computer(String name){
        super(name);
    }

    public void Action(){
        System.out.println(this.name+"のターン");
    }
}

public class Main {
    public static void main(String[] args){
        System.out.println("しりとりスタート\nしりとりの「り」からスタート");
        Player player = new Player("チャンレンジャー");
        Computer com = new Computer("数学的しりとりマスター");
        player.Action();


    }
}