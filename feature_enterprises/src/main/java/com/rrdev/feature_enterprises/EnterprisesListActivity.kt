package com.rrdev.feature_enterprises

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.rrdev.base_feature.extensions.*
import com.rrdev.base_presentation.onPostValue
import com.rrdev.feature_enterprises.adapter.EnterpriseAdapter
import com.rrdev.feature_enterprises.databinding.ActivityEnterprisesListBinding
import com.rrdev.presentation_enterprises.EnterprisesViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class EnterprisesListActivity : AppCompatActivity(), LifecycleOwner, SearchView.OnQueryTextListener {

    private val viewModel: EnterprisesViewModel by viewModel()
    private lateinit var binding: ActivityEnterprisesListBinding

    private lateinit var adapter: EnterpriseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterprisesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        addObservers()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_list, menu)
        val menuItemSearch = menu?.findItem(R.id.action_menu_toolbar_search)
        val searchView = menuItemSearch?.actionView as SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.run {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            setOnQueryTextListener(this@EnterprisesListActivity)
        }
        menuItemSearch.setOnActionExpandListener(object : MenuItem.OnActionExpandListener{
            override fun onMenuItemActionExpand(item: MenuItem?) = true

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                viewModel.fetchEnterprises()
                hideSoftKeyboard(binding.recyclerView)
                return true
            }

        })
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let {
            viewModel.fetchEnterpriseByName(it)
            hideSoftKeyboard(binding.recyclerView)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        newText?.let(viewModel::fetchEnterpriseByName)
        return true
    }

    override fun onNewIntent(intent: Intent?) {
        intent?.run {
            if (action != Intent.ACTION_SEARCH){
                super.onNewIntent(intent)
            }
            getStringExtra(SearchManager.QUERY)?.let(viewModel::fetchEnterpriseByName)
        }
    }

    private fun addObservers() {
        viewModel.allEnterprisesViewState.onPostValue(this,
            onSuccess = {
                adapter.enterpriseList = it
                if (it.isEmpty()){
                    binding.recyclerView.setGone()
                    binding.textMessage.setVisible()
                }else{
                    binding.recyclerView.setVisible()
                    binding.textMessage.setGone()
                }
            },
            onError = {
                showSnack(binding.parentList, it.message!!)
            },
            onLoading = {
                Log.d("loginViewState", "load...")
            }
        )

        viewModel.byNameEnterprisesViewState.onPostValue(this,
            onSuccess = {
                adapter.enterpriseList = it
                if (it.isEmpty()){
                    binding.recyclerView.setGone()
                    binding.textMessage.setVisible()
                }else{
                    binding.recyclerView.setVisible()
                    binding.textMessage.setGone()
                }
            },
            onError = {
                showSnack(binding.parentList, it.message!!)
            },
            onLoading = {
                Log.d("loginViewState", "load...")
            }
        )
    }

    private fun setupView() = binding.run {
        setToolbar(binding.toolbar)
        if (::adapter.isInitialized.not()){
            adapter = EnterpriseAdapter().apply {
                onItemSelect = ::handleItemClick
            }
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.adapter = adapter
        }

        viewModel.fetchEnterprises()
    }

    private fun handleItemClick(position: Int){
        val enterprise = adapter.getItemByPosition(position)
        EnterpriseDetailActivity.newActivityInstance(applicationContext, enterprise)
    }
}