package com.example.lab1_chat

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab1_chat.ui.theme.Lab1ChatTheme
import java.sql.Timestamp
import java.text.DateFormat
import java.text.SimpleDateFormat


enum class MessageStatus {
    NotSent,
    Sent,
    Received,
    Read,
}


data class Message(val author: String?, val body: String, val timestamp: Timestamp, val status: MessageStatus)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Conversation(SampleData.conversationSample)
        }
    }
}

@Composable
fun IconFromMessageStatus(messageStatus: MessageStatus) = when (messageStatus) {
    MessageStatus.NotSent -> {
        Icon(
            Icons.Default.AccessTime,
            null,
            modifier = Modifier.size(15.dp),
            tint = MaterialTheme.colorScheme.secondary,
        )
    }
    MessageStatus.Sent -> {
        Icon(
            Icons.Default.Done,
            null,
            modifier = Modifier.size(15.dp),
            tint = MaterialTheme.colorScheme.secondary,
        )
    }
    MessageStatus.Received -> {
        Icon(
            Icons.Default.DoneAll,
            null,
            modifier = Modifier.size(15.dp),
            tint = MaterialTheme.colorScheme.secondary,
        )
    }
    MessageStatus.Read -> {
        Icon(
            Icons.Default.DoneAll,
            null,
            modifier = Modifier.size(15.dp),
            tint = MaterialTheme.colorScheme.primary,
        )
    }
}

@Composable
fun MessageCard(message: Message) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            shadowElevation = 10.dp,
            modifier = Modifier
                .padding(all = 5.dp)
                .align(if (message.author == null) Alignment.CenterEnd else Alignment.CenterStart),
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(modifier = Modifier.padding(all = 10.dp)) {
                if (message.author != null) {
                    Text(
                        text = message.author,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = message.body,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Row(modifier = Modifier.align(Alignment.End)) {
                    Text(
                        text =  SimpleDateFormat("HH:mm").format(message.timestamp),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.secondary,
                    )
                    IconFromMessageStatus(message.status)
                }
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    Lab1ChatTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(messages) { message ->
                    MessageCard(message = message)
                }
            }
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun GreetingPreview() {
    Conversation(SampleData.conversationSample)
}



object SampleData {
    val conversationSample = listOf(
        Message("Sheldy", "Hey Posralk, how's it going?", Timestamp.valueOf("2024-03-31 10:15:00"), MessageStatus.Read),
        Message(null, "Hi Sheldy! I'm doing well, thanks. How about you?", Timestamp.valueOf("2024-03-31 10:16:30"), MessageStatus.Read),
        Message("Sheldy", "I'm good too, thanks for asking.", Timestamp.valueOf("2024-03-31 10:17:45"), MessageStatus.Read),
        Message(null, "That's great to hear!", Timestamp.valueOf("2024-03-31 10:18:20"), MessageStatus.Read),
        Message(null, "Did you finish that project we were working on?", Timestamp.valueOf("2024-03-31 10:20:10"), MessageStatus.Read),
        Message("Sheldy", "Not yet, but I'm almost done with it.", Timestamp.valueOf("2024-03-31 10:21:40"), MessageStatus.Read),
        Message("Sheldy", "spam baram paparam badam", Timestamp.valueOf("2024-03-31 10:21:40"), MessageStatus.Read),
        Message("Sheldy", "spam baram paparam badam", Timestamp.valueOf("2024-03-31 10:21:40"), MessageStatus.Read),
        Message("Sheldy", "spam baram paparam badam", Timestamp.valueOf("2024-03-31 10:21:40"), MessageStatus.Read),
        Message("Sheldy", "spam baram paparam badam", Timestamp.valueOf("2024-03-31 10:21:40"), MessageStatus.Read),
        Message("Sheldy", "spam baram paparam badam", Timestamp.valueOf("2024-03-31 10:21:40"), MessageStatus.Read),
        Message("Sheldy", "spam baram paparam badam", Timestamp.valueOf("2024-03-31 10:21:40"), MessageStatus.Read),
        Message("Sheldy", "spam baram paparam badam", Timestamp.valueOf("2024-03-31 10:21:40"), MessageStatus.Read),
        Message("Sheldy", "spam baram paparam badam", Timestamp.valueOf("2024-03-31 10:21:40"), MessageStatus.Read),
        Message("Sheldy", "spam baram paparam badam", Timestamp.valueOf("2024-03-31 10:21:40"), MessageStatus.Read),
        Message("Sheldy", "spam baram paparam badam", Timestamp.valueOf("2024-03-31 10:21:40"), MessageStatus.Read),
        Message("Sheldy", "spam baram paparam badam", Timestamp.valueOf("2024-03-31 10:21:40"), MessageStatus.Read),
        Message("Sheldy", "spam baram paparam badam", Timestamp.valueOf("2024-03-31 10:21:40"), MessageStatus.Read),
        Message(null, "Okay, take your time. Let me know if you need any help.", Timestamp.valueOf("2024-03-31 10:22:55"), MessageStatus.Read),
        Message("Sheldy", "Sure, thanks!", Timestamp.valueOf("2024-03-31 10:23:30"), MessageStatus.Read),
        Message(null, "привет", Timestamp.valueOf("2024-03-31 10:23:30"), MessageStatus.Received),
        Message(null, "займи пять тыщ", Timestamp.valueOf("2024-03-31 10:23:30"), MessageStatus.Sent),
        Message(null, "это не скам вот номер карты ******", Timestamp.valueOf("2024-03-31 10:23:30"), MessageStatus.NotSent),

        )
}
