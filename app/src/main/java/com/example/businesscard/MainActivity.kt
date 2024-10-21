package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    BusinessCard(
                        R.drawable.android_logo,
                        stringResource(R.string.name),
                        stringResource(R.string.title),
                        stringResource(R.string.phone),
                        stringResource(R.string.social),
                        stringResource(R.string.email)
                    )
                }
            }

        }
    }
}


@Composable
private fun MainDetails(logo: Int, name: String, title: String, modifier: Modifier = Modifier){
    val image = painterResource(logo)

    Spacer(modifier = Modifier.height(150.dp))
    Image(
        painter = image,
        contentDescription = "logo",
        modifier = Modifier
            .background(Color(0xFF281A5B))
            .height(200.dp)
            .width(180.dp)
    )
    Text(
        text = name,
        fontSize = 34.sp,
        modifier = Modifier

    )
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF055B2B),
        modifier = modifier
    )
}

@Composable
private fun RowInfo(
    icon: ImageVector,
    key: String,
    value: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.width(50.dp))
        Icon(
            imageVector = icon,
            contentDescription = "$key icon",
            tint = Color(0xFF055B2B),
            modifier = Modifier
                .weight(1f)
        )
        Text(
            text = value,
            textAlign = TextAlign.Left,
            fontSize = 16.sp,
            modifier = Modifier
                .weight(2f)
        )
    }
}

@Composable
private fun ContactDetails(phone: String, social: String, email: String, modifier: Modifier = Modifier){
    Spacer(modifier = Modifier.height(200.dp))
    RowInfo(Icons.Rounded.Phone, "phone", phone)
    RowInfo(Icons.Rounded.Share, "share", social)
    RowInfo(Icons.Rounded.Email, "email", email)
}

@Composable
fun BusinessCard(logo: Int, name: String, title: String, phone: String, social: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(Color(0xFFB9CCB9)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        MainDetails(logo,name,title)
        ContactDetails(phone, social, email)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCard(
        R.drawable.android_logo,
        stringResource(R.string.name),
        stringResource(R.string.title),
        stringResource(R.string.phone),
        stringResource(R.string.social),
        stringResource(R.string.email)
    )
}