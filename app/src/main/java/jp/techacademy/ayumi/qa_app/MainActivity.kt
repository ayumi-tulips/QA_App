package jp.techacademy.ayumi.qa_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle    // ← 追加
import androidx.core.view.GravityCompat    // ← 追加
import com.google.android.material.navigation.NavigationView    // ← 追加
import com.google.firebase.auth.FirebaseAuth  // ← 追加
// findViewById()を呼び出さずに該当Viewを取得するために必要となるインポート宣言
import kotlinx.android.synthetic.main.activity_main.*  // ← 追加
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*    // ← 追加


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var mGenre = 0    /

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // idがtoolbarがインポート宣言により取得されているので
        // id名でActionBarのサポートを依頼
        setSupportActionBar(toolbar)

        // fabにClickリスナーを登録
        fab.setOnClickListener { _ ->
            // ログイン済みのユーザーを取得する
            val user = FirebaseAuth.getInstance().currentUser

            // ログインしていなければログイン画面に遷移させる
            if (user == null) {
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
    }
}
// ～～ ここから
        // ナビゲーションドロワーの設定
        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.app_name, R.string.app_name)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

    // ～～ ここまで

}

override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
}

override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    return when (item.itemId) {
        R.id.action_settings -> true
        else -> super.onOptionsItemSelected(item)
    }
}
    // ～～ ここから
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.nav_hobby) {
            toolbar.title = getString(R.string.menu_hobby_label)
            mGenre = 1
        } else if (id == R.id.nav_life) {
            toolbar.title = getString(R.string.menu_life_label)
            mGenre = 2
        } else if (id == R.id.nav_health) {
            toolbar.title = getString(R.string.menu_health_label)
            mGenre = 3
        } else if (id == R.id.nav_compter) {
            toolbar.title = getString(R.string.menu_compter_label)
            mGenre = 4
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
    // ～～ ここまで
    }
