package com.samuel.movie_dimensa_app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.samuel.movie_dimensa_app.ui.state.DialogState
import com.samuel.movie_dimensa_app.ui.state.UiState
import com.samuel.movie_dimensa_app.ui.theme.openSansFontFamily

@Composable
fun AppDialog(
  state: DialogState,
  modifier: Modifier = Modifier
) {
  if (state.isOpen) {
    Dialog(
      onDismissRequest = state.onDismiss
    ) {
      Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
          containerColor = Color(0xFF242135),
          contentColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(16.dp),
      ) {
        Column(
          modifier = Modifier.padding(16.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          state.title?.let {
            Text(
              text = it,
              color = Color(0xFFDEDDDF),
              fontFamily = openSansFontFamily,
              fontWeight = FontWeight(600),
              fontSize = 21.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
          }
          state.message?.let {
            Text(
              text = it,
              color = Color(0xFFDEDDDF),
              fontFamily = openSansFontFamily,
              fontWeight = FontWeight(400),
              fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
          }
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
          ) {
            Button(
              onClick = state.onDismiss,
              colors = ButtonColors(
                containerColor = Color(0xFF820AD1),
                contentColor = Color(0xFFFFFFFF),
                disabledContainerColor = Color(0xFF665287),
                disabledContentColor = Color(0xFFFFFFFF)
              )
            ) {
              Text("Ok")
            }
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun AppDialogPreview() {
  AppDialog(
    state = DialogState(
      isOpen = true,
      title = "Erro",
      message = "Erro ao carregar filmes",
    )
  )
}