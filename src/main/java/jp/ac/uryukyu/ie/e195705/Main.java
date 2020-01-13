package jp.ac.uryukyu.ie.e195705;

import java.util.*;

abstract class Character{
    String name;

    void Name(String name) {
        this.name = name;
    }
}

class Words {
    //効率よくしりとりを行いたいため全てをカタカナで表記する。わかりにくい場合は()を用いて表記する。
    List<String> words = new ArrayList<>();
    List<String> words_A = new ArrayList<>(Arrays.asList("アルキメデス", "インテグラル", "ウ（裏）ラ", "エピサイクロイド", "オイラー"));
    List<String> words_K = new ArrayList<>(Arrays.asList("カクリツブン（確率分布）プ", "キョス（虚数）ウ", "クラインノツ（クラインの壺）ボ", "ケーニヒスベルグ", "コセカント"));
    List<String> words_S = new ArrayList<>(Arrays.asList("サイクロイド", "シゼンタイス（自然対数）ウ", "スーパーソス（スーパー素数）ウ", "セイキブン（正規分布）プ", "ソインスウブンカ（素因数分解）イ"));
    List<String> words_T = new ArrayList<>(Arrays.asList("タンジェント", "チャンパーノウンテイス（チャンパーノウン定数）ウ", "ツェラーノコウシ（ツェラーの公式）キ", "テイラーテンカ（テイラー展開）イ", "トクセイホウテイシ（特性方程式）キ"));
    List<String> words_N = new ArrayList<>(Arrays.asList("ナン（NAND）ド", "ニコウケイス（二項係数）ウ", "", "ネイピアス（ネイピア数）ウ", "ノウ（濃度）ド"));
    List<String> words_H = new ArrayList<>(Arrays.asList("ハミルトンサイクル", "ヒルベルトホテル", "フィボナッチスウレ（フィボナッチ数列）ツ", "ヘロンノコウシ（ヘロンの公式）キ", "ホシュウゴ（補集合）う"));
    List<String> words_M = new ArrayList<>(Arrays.asList("マンデルブロシュウゴ（マンデルブロ集合）ウ", "ミチス（未知数）ウ", "ムゲンダ（無限大）イ", "メルセンヌ", "モンテカルロホ（モンテカルロ法）ウ"));
    List<String> words_Y = new ArrayList<>(Arrays.asList("ヤコビギョウレ（ヤコビ行列）ツ","", "ユークリッド","", "ヨゲンテイ（余弦定理）リ"));
    List<String> words_R = new ArrayList<>(Arrays.asList("ライプニッツ", "リシンリ（離心率）ツ", "ルーローノサンカッケ（ルーローの三角形）イ", "レーダーチャート", "ロンリエンザン（論理演算子）シ"));

    List<String> char_words = new ArrayList<>();
    List<String> char_words_All = new ArrayList<>(Arrays.asList("ア","イ","ウ","エ","オ","カ","キ","ク","ケ","コ","サ","シ","ス","セ","ソ","タ","チ","ツ","テ","ト","ナ","ニ","ヌ","ネ","ノ","ハ","ヒ","フ","ヘ","ホ","マ","ミ","ム","メ","モ","ヤ","","ユ","","ヨ","ラ","リ","ル","レ","ロ"));

    void words(){
        //javaにはタプルが存在しないため、1行で要素を追加した。（そうでないと行数を稼いでるようになってしまうので、、）
        words.addAll(words_A);words.addAll(words_K);words.addAll(words_S);words.addAll(words_T);words.addAll(words_N);words.addAll(words_H);words.addAll(words_M);words.addAll(words_Y);words.addAll(words_R);
    }

    void char_words(){
        char_words.addAll((char_words_All));
    }
}

class Player extends Character{
    void Player_name(String name) {
        Name(name);
    }

    public void Action_P(){
        System.out.println(this.name+"のターン");
    }
}

class Computer extends Character{
    void Computer_name(String name){
        Name("しりとりマスター");
    }

    public void Action_C(){
        System.out.println(this.name+"のターン");
    }
}

class Action{
    int count = 0;
    String word_end;
    String word_initial;
    public void Action(){
        while (count <= 0){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();//String型の文字列を入力したいからnextLine()を用いる
            word_end = input.substring(input.length() -1);//入力した文字列の末尾1文字を取得する
            if (word_end.matches("[ア-ン]")) {//正規表現は""で括る
                if (word_end.matches(("[ヌワヲ]"))) {
                    System.out.println("そのような数学的単語は私には見つけられぬ、、\n貴様の勝ちだ");
                    break;
                }if (word_end.matches(("[ン]"))) {
                    System.out.println("貴様はしりとりのルールも知らんのか！\nもう一回だ");
                    break;
                }if (word_end.matches("[ーャュョ　]")){
                    System.out.println("あ、それはなしで、、");
                    continue;
                }Computer com = new Computer();
                com.Computer_name("しりとりマスター");
                com.Action_C();
                Words word = new Words();
                word.words();
                Words char_word = new Words();
                char_word.char_words();
                int num = char_word.char_words.indexOf(word_end);
                System.out.println("→"+word.words.get(num));
                word_initial = word.words.get(num).substring(word.words.get(num).length() -1);
                break;
            }else {
                System.out.println("申し訳ないがカタカナ表記で頼む、、");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int count = 0;
        System.out.println("システムの都合上、濁音半濁音はなしだ。（）\nしりとりスタート\nしりとりの「り」からスタート");
        Player player = new Player();
        player.Player_name("チャレンジャー");
        while (true) {
            player.Action_P();
            while (true) {
                Action action = new Action();
                action.Action();
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                while (count <= 0){
                    if (action.word_initial.equals(input)){
                    }else{
                        System.out.println("違う違う！");
                        break;
                    }
                }
            }
        }
    }
}