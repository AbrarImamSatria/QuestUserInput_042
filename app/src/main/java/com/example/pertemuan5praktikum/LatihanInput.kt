package com.example.pertemuan5praktikum

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview (showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier){
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTelpon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var memilihJk by remember { mutableStateOf("") }

    var namasv by remember { mutableStateOf("") }
    var emailsv by remember { mutableStateOf("") }
    var noTelponsv by remember { mutableStateOf("") }
    var alamatsv by remember { mutableStateOf("") }
    var memilihJksv by remember { mutableStateOf("") }

    val listJk = listOf("Laki-Laki","Perempuan")

    Column (modifier = modifier
        .fillMaxSize()
        .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Biodata",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier. padding(16.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("nama")},
            placeholder = { Text("Masukan Nama Anda")}
        )

        Row {
            listJk.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){ RadioButton(
                    selected = memilihJk == item,
                    onClick = {
                        memilihJk = item
                    }
                )
                    Text(item)
                }
            }
        }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = { Text("email")},
            placeholder = { Text("Masukan email Anda")}
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = noTelpon,
            onValueChange = {noTelpon = it},
            label = { Text("NoTelepon")},
            placeholder = { Text("Masukan noTelepon Anda")}
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("Alamat")},
            placeholder = { Text("Masukan Alamat Anda")}
        )

        Button(onClick = {
            namasv = nama
            emailsv = email
            noTelponsv = noTelpon
            alamatsv = alamat
            memilihJksv = memilihJk
        }) {
            Text("Submit")
        }

        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
            .fillMaxWidth()
        ){
            DetailMassage(judul = "nama", isinya = namasv)
            DetailMassage(judul = "email", isinya = emailsv)
            DetailMassage(judul = "noTelpom", isinya = noTelponsv)
            DetailMassage(judul = "alamat", isinya = alamatsv)
            DetailMassage(judul = "memilihJk", isinya = memilihJksv)
        }
    }
}

@Composable
fun DetailMassage(
    judul: String,isinya: String
){
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
        ){
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = isinya,
                modifier = Modifier.weight(2f))
        }
}
