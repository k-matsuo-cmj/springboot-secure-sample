# ログイン機能実装デモ

1. SecurityConfig(/config)
   SpringSecurity 機能を有効にするための設定を行うクラス

   - @EnableWebSecurity で SpringSecurity を有効化
   - BCryptPasswordEncoder : パスワードをハッシュ化するエンコーダーの定義
   - configure() : セキュリティ設定
     - Web : Web アプリ全体の設定 static ファイルにアクセスできるようセキュリティを無効にしておく
     - HTTP : URL 毎に認証の要否を設定、ログイン・ログアウト方法の指定
     - Auth : 認証方法 → UserDetailsServeice を使用する（後述）

2. UserDetailsService インターフェースを実装する(/service)
   ユーザ情報を取得するためのインターフェース

   - DB のユーザ情報を取得して処理する
     - 存在しない場合は、UsernameNotFoundException をスロー
     - 存在する場合は、SpringSecurity のデータ型に変換する

3. CustomUser モデル・リポジトリ(/model)
   DB のユーザー情報の定義

   - エンティティクラス名は「User」にしないほうが無難
   - リポジトリには「findByName」メソッドを定義しておく（UserDetailsService が使用する）

4. HTML テンプレート(resources/templates)
   Thymeleaf の機能でログインの有無や権限による判定が可能（表示の切り替えができる）

   https://kagamihoge.hatenablog.com/entry/2019/11/12/195357
