package rachman.forniandi.advancecomposeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composerecyclerview.compose.TvShowListItem
import rachman.forniandi.advancecomposeapp.data.TvShowList
import rachman.forniandi.advancecomposeapp.model.TvShow
import rachman.forniandi.advancecomposeapp.ui.theme.AdvanceComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ScrollColumnDemo()
            //LazyColumnDemo()
            /*LazyColumnDemo2{
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
            }*/
            DisplayTvShows{
                startActivity(InfoActivity.intent(this,it))
            }
        }
    }
}


@Composable
fun ScrollColumnDemo(){
val scrollState = rememberScrollState()
    Column (modifier = Modifier.verticalScroll(scrollState)){
        for (i in 1..100){
            Text(
                "User Name $i",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(10.dp)
            )
            Divider(color = Color.Black,thickness = 5.dp)
        }
    }
}

@Composable
fun LazyColumnDemo(){
    LazyColumn{
        items(100){
            Text(
                "User Name $it",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(10.dp)
            )
            Divider(color = Color.Black,thickness = 5.dp)
        }
    }
}

@Composable
fun LazyColumnDemo2(selectedItem : (String)->(Unit)){
    LazyColumn{
        items(100){
            Text(
                "User Name $it",
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { selectedItem("$it selected") }
            )
            Divider(color = Color.Black,thickness = 5.dp)
        }
    }
}

//Displaying TvShow list

@Composable
fun DisplayTvShows(selectedItem: (TvShow) -> Unit) {
    val tvShows = remember {
        TvShowList.tvShows
    }

    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp,vertical = 8.dp)
    ){
        items(
            items = tvShows,
            itemContent = {
                TvShowListItem(tvShow = it, selectedItem)
            }
        )
    }
}