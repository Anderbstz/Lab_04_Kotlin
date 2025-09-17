package com.example.lab_03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                ComponentShowcase()
            }
        }
    }
}

/* ------------------ CONTENEDORES ------------------ */

@Composable
fun LazyColumnExample() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(count = 10) { index ->
            Text("LazyColumn Item $index", modifier = Modifier.padding(4.dp))
        }
    }
}

@Composable
fun LazyRowExample() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(count = 5) { index ->
            Card(
                modifier = Modifier.size(80.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text("$index")
                }
            }
        }
    }
}

@Composable
fun GridExample() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(9) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text("Grid $index")
                }
            }
        }
    }
}

@Composable
fun ConstraintLayoutExample() {
    // Simulación de ConstraintLayout usando Box y posicionamiento
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Text(
            "Top Start",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Text(
            "Top End",
            modifier = Modifier.align(Alignment.TopEnd)
        )
        Text(
            "Center",
            modifier = Modifier.align(Alignment.Center)
        )
        Text(
            "Bottom Center",
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.height(300.dp),
        topBar = {
            TopAppBar(title = { Text("Scaffold Example") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("FAB clicked!")
                    }
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            BottomAppBar {
                Text("Bottom Bar", modifier = Modifier.padding(16.dp))
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Scaffold Content Area")
            Text("Padding applied automatically")
        }
    }
}

@Composable
fun SurfaceExample() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Surface with elevation and rounded corners")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        AssistChip(
            onClick = { },
            label = { Text("Assist") },
            leadingIcon = { Icon(Icons.Default.Star, contentDescription = null, modifier = Modifier.size(18.dp)) }
        )
        FilterChip(
            selected = false,
            onClick = { },
            label = { Text("Filter") }
        )
        SuggestionChip(
            onClick = { },
            label = { Text("Suggestion") }
        )
    }
}

@Composable
fun BackdropScaffoldExample() {
    // Material3 no tiene BackdropScaffold, simulamos el concepto
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(if (expanded) 0.3f else 0.7f),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text("Backdrop Header", color = MaterialTheme.colorScheme.onPrimary)
                Button(
                    onClick = { expanded = !expanded },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                ) {
                    Text("Toggle")
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(if (expanded) 0.7f else 0.3f),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text("Backdrop Content Area")
            }
        }
    }
}

@Composable
fun FlowRowExample() {
    // Simulamos FlowRow con Wrap usando Column y Rows
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("FlowRow Simulation:", fontWeight = FontWeight.Bold)
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(3) { index ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Text("Item $index", modifier = Modifier.padding(8.dp))
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(2) { index ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                ) {
                    Text("Item ${index + 3}", modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun FlowColumnExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.weight(1f)
        ) {
            Text("Col 1:", fontWeight = FontWeight.Bold, fontSize = 12.sp)
            repeat(3) { index ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
                ) {
                    Text("A$index", modifier = Modifier.padding(4.dp), fontSize = 12.sp)
                }
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.weight(1f)
        ) {
            Text("Col 2:", fontWeight = FontWeight.Bold, fontSize = 12.sp)
            repeat(2) { index ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Text("B$index", modifier = Modifier.padding(4.dp), fontSize = 12.sp)
                }
            }
        }
    }
}

/* ------------------ CONTROLES ------------------ */

@Composable
fun AlertDialogExample() {
    var showDialog by remember { mutableStateOf(false) }

    Column {
        Button(onClick = { showDialog = true }) {
            Text("Show AlertDialog")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Alert Dialog") },
                text = { Text("This is an example of AlertDialog component") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

@Composable
fun CardExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Card(
            modifier = Modifier.size(80.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text("Card 1")
            }
        }
        Card(
            modifier = Modifier.size(80.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text("Card 2")
            }
        }
    }
}

@Composable
fun CheckboxExample() {
    var checked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
        Text("Checkbox ${if (checked) "Checked" else "Unchecked"}")
    }
}

@Composable
fun FloatingActionButtonExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FloatingActionButton(
            onClick = { },
            modifier = Modifier.size(56.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }

        ExtendedFloatingActionButton(
            onClick = { },
            icon = { Icon(Icons.Default.Edit, contentDescription = null) },
            text = { Text("Extended FAB") }
        )
    }
}

@Composable
fun IconExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.Favorite, contentDescription = "Favorite")
        Icon(Icons.Default.Star, contentDescription = "Star", tint = Color.Yellow)
        Icon(Icons.Default.Home, contentDescription = "Home", modifier = Modifier.size(32.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {
    TopAppBar(
        title = { Text("TopAppBar") },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Default.MoreVert, contentDescription = "More")
            }
        }
    )
}

/* ------------------ COMPONENTE PRINCIPAL SHOWCASE ------------------ */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentShowcase() {
    Scaffold(
        topBar = {
            TopAppBarExample()
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    "CONTENEDORES",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            item {
                ComponentCard("LazyColumn") { LazyColumnExample() }
            }
            item {
                ComponentCard("LazyRow") { LazyRowExample() }
            }
            item {
                ComponentCard("Grid (LazyVerticalGrid)") { GridExample() }
            }
            item {
                ComponentCard("ConstraintLayout") { ConstraintLayoutExample() }
            }
            item {
                ComponentCard("Scaffold") { ScaffoldExample() }
            }
            item {
                ComponentCard("Surface") { SurfaceExample() }
            }
            item {
                ComponentCard("Chip") { ChipExample() }
            }
            item {
                ComponentCard("BackdropScaffold") { BackdropScaffoldExample() }
            }
            item {
                ComponentCard("FlowRow") { FlowRowExample() }
            }
            item {
                ComponentCard("FlowColumn") { FlowColumnExample() }
            }

            item {
                Text(
                    "CONTROLES",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

        }
    }
}

@Composable
fun ComponentCard(
    title: String,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.primary
            )
            content()
        }
    }
}
/* ------------------ PREVIEWS ------------------ */

@Preview(showBackground = true)
@Composable
fun PreviewComponentShowcase() {
    MaterialTheme {
        ComponentShowcase()
    }
}   