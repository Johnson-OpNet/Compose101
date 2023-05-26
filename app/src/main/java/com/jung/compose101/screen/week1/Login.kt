package com.jung.compose101.screen.week1

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jung.compose101.R
import com.jung.compose101.ui.theme.Compose101Theme
import com.jung.compose101.ui.theme.Pink80
import com.jung.compose101.ui.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login() {

    var pwd by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        UserMenu()

        OutlinedTextField(
            value = pwd,
            onValueChange = { pwd = it },
            modifier = Modifier.fillMaxWidth(.7f),
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
            ),
        )

        Button(
            onClick = { showDialog = true },
            modifier = Modifier.fillMaxWidth(.7f),
            enabled = pwd.isNotBlank(),
        ) {
            Text(text = "Login")
        }
    }

    if (showDialog) {
        ErrorDialog(onDismiss = { showDialog = false })
    }
}

@Composable
private fun ErrorDialog(onDismiss: () -> Unit) {
    DialogContainer(onDismiss = onDismiss) {
        Column(
            modifier = Modifier.padding(all = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Password Error !!!",
                modifier = Modifier.padding(vertical = 8.dp),
            )

            Button(
                onClick = onDismiss,
                modifier = Modifier.width(120.dp),
            ) {
                Text(text = "Close")
            }
        }
    }
}


private val users = listOf("James", "Eric", "Howard", "Jerry")

@Composable
private fun UserMenu() {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    Box {
        Row(
            modifier = Modifier.fillMaxWidth(.7f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "User : ")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PurpleGrey80)
                    .padding(vertical = 8.dp, horizontal = 16.dp)
                    .clickable(onClick = { expanded = true }),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(text = users[selectedIndex])
                Icon(
                    painter = painterResource(id = R.drawable.round_arrow_down),
                    contentDescription = null,
                )
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth(.7f)
                .background(Pink80)
        ) {
            users.forEachIndexed { index, user ->
                DropdownMenuItem(
                    text = { Text(text = user) },
                    onClick = {
                        selectedIndex = index
                        expanded = false
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Compose101Theme {
        Login()
    }
}