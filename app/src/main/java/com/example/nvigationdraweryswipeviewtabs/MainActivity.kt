package com.example.nvigationdraweryswipeviewtabs

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firdFradment = TabFragment()
        val secondFradment = SecondFragment()
        val thirdFragment = ThirdFragment()

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment, firdFradment)
            //Metodo para volver a aun fragment con el boton Back del celular
            addToBackStack(null)
            //metodo para confirmar el cambio de Fragment
            commit()
        }
        navView.setNavigationItemSelectedListener {
            //Metodo para remplazar los fragment
            when (it.itemId) {
                R.id.item1 -> supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flfragment, firdFradment)
                    //Metodo para volver a aun fragment con el boton Back del celular
                    addToBackStack(null)
                    //metodo para confirmar el cambio de Fragment
                    commit()
                }
                R.id.item2 -> supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flfragment, secondFradment)
                    addToBackStack(null)
                    commit()
                }
                R.id.item3 -> supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flfragment, thirdFragment)
                    addToBackStack(null)
                    commit()
                }
            }
            itemClose()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun itemClose(): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}