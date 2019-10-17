package matrixsystems.genericrecyclerviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager





class MainActivity : AppCompatActivity() , GenericAdapter.ItemClickListener {

    lateinit var recyclerView : RecyclerView

    lateinit var genericAdapter: GenericAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // data to populate the RecyclerView with
        val animalNames = mutableListOf<String>()
        animalNames.add("Horse")
        animalNames.add("Cow")
        animalNames.add("Camel")
        animalNames.add("Sheep")
        animalNames.add("Goat")

        recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        genericAdapter = GenericAdapter(this, R.layout.row_test, animalNames)
        genericAdapter.setClickListener(this)
        recyclerView.adapter = genericAdapter
    }


    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(this, "You clicked " + genericAdapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show()
    }
}
