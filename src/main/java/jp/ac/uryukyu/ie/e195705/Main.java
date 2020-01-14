package jp.ac.uryukyu.ie.e195705;

import java.util.*;

/**
 * キャラクターの名前を使い回す
 */
abstract class Character{
    String name;

    void Name(String name) {
        this.name = name;
    }
}

/**
 * words -> 自分で用意した50音（正確には42音）から始まる単語をリストに用意した。
 * char_words -> 自分で用意した50音から始まる単語を取り出すために、50音をリストに用意した。
 */
class Words {
    //効率よくしりとりを行いたいため全てをカタカナで表記する。わかりにくい場合は()を用いて表記する。
    List<String> words = new ArrayList<>();
    List<String> words_A = new ArrayList<>(Arrays.asList("アルキメデス", "インテグラル", "ウ（裏）ラ", "エラトステネスノフル（エラトステネスの篩）イ", "オイラーノコウシ（オイラーの公式）キ"));
    List<String> words_K = new ArrayList<>(Arrays.asList("カクリ（確率）ツ", "キョス（虚数）ウ", "クミアワ（組み合わせ）セ", "ケーニヒスベルグノハ（ケーニヒスベルグの橋）シ", "コセカント"));
    List<String> words_S = new ArrayList<>(Arrays.asList("サンカクス（三角数）ウ", "シゼンタイス（自然対数）ウ", "スーパーソス（スーパー素数）ウ", "セイタメンタ（正多面体）イ", "ソインスウブンカ（素因数分解）イ"));
    List<String> words_T = new ArrayList<>(Arrays.asList("タンジェント", "チャンパーノウンテイス（チャンパーノウン定数）ウ", "ツェラーノコウシ（ツェラーの公式）キ", "テイラーテンカ（テイラー展開）イ", "トクセイホウテイシ（特性方程式）キ"));
    List<String> words_N = new ArrayList<>(Arrays.asList("ナユ（那由多）タ", "ニコウケイス（二項係数）ウ", "", "ネイピアス（ネイピア数）ウ", "ノ（NOR）ア"));
    List<String> words_H = new ArrayList<>(Arrays.asList("ハミルトンサイクル", "ヒルベルトホテル", "フィボナッチスウレ（フィボナッチ数列）ツ", "ヘロンノコウシ（ヘロンの公式）キ", "ホシュウゴ（補集合）ウ"));
    List<String> words_M = new ArrayList<>(Arrays.asList("マンデルブロシュウゴ（マンデルブロ集合）ウ", "ミチス（未知数）ウ", "ムゲンダ（無限大）イ", "メルセンヌ", "モンテカルロホ（モンテカルロ法）ウ"));
    List<String> words_Y = new ArrayList<>(Arrays.asList("ヤコビギョウレ（ヤコビ行列）ツ","", "ユークリッドノゴジョホ（ユークリッドの互除法）ウ","", "ヨゲンテイ（余弦定理）リ"));
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

/**
 * しりとりのルールに従って、場合分けを行っているクラス。
 *
 */
class Action{
    int count = 0;
    String input;//userが入力した文字列を保存する
    String word_end;//userが入力した文字列の末尾1文字を保存する
    String word_initial;//computerが出力した時の頭1文字を保存する

    public void Action(){
        Words word = new Words();
        word.words();
        Words char_word = new Words();
        char_word.char_words();
        while (count <= 0){
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
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
                int num = char_word.char_words.indexOf(word_end);
                System.out.println("→"+word.words.get(num));
                word_initial = word.words.get(num).substring(word.words.get(num).length() -1);//しりとりマスターの返答の末尾1文字を取得
                break;
            }else {
                System.out.println("申し訳ないがカタカナ表記で頼む、、");
            }
        }
    }
}

/**
 * しりとり
 *　引数なし
 */
public class Main {
    public static void main(String[] args) {
        int count = 0;
        System.out.println("システムの都合上、濁音半濁音はなしだ。（）\nしりとりスタート\nなんでもええよ");
        Player player = new Player();
        player.Player_name("チャレンジャー");
        Words word = new Words();
        word.words();
        Words char_word = new Words();
        char_word.char_words();
        Action action = new Action();
        while (true) {
            player.Action_P();
            action.Action();
            while (count <= 0){
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if(action.word_initial.equals(input.substring(0,1))){
                    int num = char_word.char_words.indexOf(input.substring(input.length() - 1));
                    System.out.println("→"+word.words.get(num));
                    break;
                }if(action.word_end.equals(input.substring(0,1))){
                    action.Action();
                }
                else{
                    System.out.println("違う違う");
                }
            }
        }
    }
}