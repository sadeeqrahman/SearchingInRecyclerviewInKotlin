package com.encoders.searchinginrecyclerviewinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.encoders.searchinginrecyclerviewinkotlin.Adapter.UserListAdapter
import com.encoders.searchinginrecyclerviewinkotlin.Adapter.onBudgetChartClickListner
import com.encoders.searchinginrecyclerviewinkotlin.Model.User

class MainActivity : AppCompatActivity(), onBudgetChartClickListner {
    private var user_list: MutableList<User> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var search_member: EditText
    private lateinit var filtered_User: MutableList<User>
    private lateinit var userListAdapter: UserListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.users_list)

        Get_Users_List()

          userListAdapter =
            UserListAdapter(
                user_list, this@MainActivity
            )
        recyclerView.adapter = userListAdapter


        recyclerView.layoutManager = LinearLayoutManager(
            this@MainActivity,
            LinearLayoutManager.VERTICAL,
            false
        )


        search_member = findViewById(R.id.search_member)
        search_member.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun afterTextChanged(editable: Editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString())
            }
        })


    }

    override fun onBudgetChartClickListner(user: User, position: Int) {

    }

    fun Get_Users_List(){
        user_list.add(User("Sadeeq Rahman", "26"))
        user_list.add(User("UbaidUllah", "20"))
        user_list.add(User("Abbas sher", "22"))
        user_list.add(User("Waqas Rahman", "22"))
        user_list.add(User("Saifullah", "23"))
        user_list.add(User("Waqar", "20"))
        user_list.add(User("Sadeeq Rahman", "26"))
        user_list.add(User("UbaidUllah", "20"))
        user_list.add(User("Abbas sher", "22"))
        user_list.add(User("Waqas Rahman", "22"))
        user_list.add(User("Saifullah", "23"))
        user_list.add(User("Waqar", "20"))
        user_list.add(User("Sadeeq Rahman", "26"))
        user_list.add(User("UbaidUllah", "20"))
        user_list.add(User("Abbas sher", "22"))
        user_list.add(User("Waqas Rahman", "22"))
        user_list.add(User("Saifullah", "23"))
        user_list.add(User("Waqar", "20"))
        user_list.add(User("Sadeeq Rahman", "26"))
        user_list.add(User("UbaidUllah", "20"))
        user_list.add(User("Abbas sher", "22"))
        user_list.add(User("Waqas Rahman", "22"))
        user_list.add(User("Saifullah", "23"))
        user_list.add(User("Waqar", "20"))
        user_list.add(User("Sadeeq Rahman", "26"))
        user_list.add(User("UbaidUllah", "20"))
        user_list.add(User("Abbas sher", "22"))
        user_list.add(User("Waqas Rahman", "22"))
        user_list.add(User("Saifullah", "23"))
        user_list.add(User("Waqar", "20"))
    }




    private fun filter(text: String) {
        filtered_User= ArrayList<User>()
            ////// SEARCH BY NAME /////
        user_list.filterTo(filtered_User) {

            it.name.toLowerCase().contains(text.toLowerCase())
        }
        ////// SEARCH BY AGE /////
        user_list.filterTo(filtered_User) {

            it.age.toLowerCase().contains(text.toLowerCase())
        }


        userListAdapter!!.filterList(filtered_User)
    }


}