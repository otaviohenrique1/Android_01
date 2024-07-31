package br.com.alura.orgs.ui.activty

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutoDAO
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraReciclerView()
    }

    override fun onResume() {
        super.onResume()

        // Navegação entre telas
        configuraFab()
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configuraReciclerView() {
        val dao = ProdutoDAO()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        Log.i("MainActivity", "onCreate: ${dao.buscaTodos()}")
        recyclerView.adapter = ListaProdutosAdapter(
            context = this,
            produtos = dao.buscaTodos()
        )
    }
}