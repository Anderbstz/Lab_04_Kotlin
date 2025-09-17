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

@Composable
fun ImageExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Simulamos imágenes con íconos ya que no tenemos recursos
        Card(
            modifier = Modifier.size(64.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Icon(Icons.Default.Star, contentDescription = "Image placeholder", modifier = Modifier.size(32.dp))
            }
        }
        Card(
            modifier = Modifier.size(64.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Icon(Icons.Default.Star, contentDescription = "Photo placeholder", modifier = Modifier.size(32.dp))
            }
        }
    }
}

@Composable
fun ProgressBarExample() {
    var progress by remember { mutableFloatStateOf(0.3f) }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth()
        )
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularProgressIndicator(progress = { progress })
            CircularProgressIndicator()
        }

        Button(onClick = { progress = if (progress >= 1f) 0f else progress + 0.1f }) {
            Text("Update Progress")
        }
    }
}

@Composable
fun RadioButtonExample() {
    val options = listOf("Option 1", "Option 2", "Option 3")
    var selectedOption by remember { mutableStateOf(options[0]) }

    Column {
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { selectedOption = option }
                )
                Text(option)
            }
        }
    }
}

@Composable
fun SliderExample() {
    var sliderValue by remember { mutableFloatStateOf(50f) }
    Column {
        Text("Value: ${sliderValue.toInt()}")
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..100f,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun SpacerExample() {
    Column {
        Text("Before Spacer")
        Spacer(modifier = Modifier.height(24.dp))
        Text("After Spacer (24.dp)")
        Spacer(modifier = Modifier.height(8.dp))
        Text("After smaller Spacer (8.dp)")
    }
}

@Composable
fun SwitchExample() {
    var checked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Switch(
            checked = checked,
            onCheckedChange = { checked = it }
        )
        Text("Switch is ${if (checked) "ON" else "OFF"}")
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

@Composable
fun BottomNavigationExample() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Home", "Search", "Profile")
    val icons = listOf(Icons.Default.Home, Icons.Default.Search, Icons.Default.Person)

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

@Composable
fun DialogExample() {
    var showDialog by remember { mutableStateOf(false) }

    Column {
        Button(onClick = { showDialog = true }) {
            Text("Show Dialog")
        }

        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("Custom Dialog")
                        Text("This is a custom dialog content")
                        Button(
                            onClick = { showDialog = false },
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text("Close")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DividerExample() {
    Column {
        Text("Above Divider")
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Below Divider")
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.primary
        )
        Text("Below Thick Colored Divider")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenuExample() {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Select Option") }
    val options = listOf("Option 1", "Option 2", "Option 3", "Option 4")

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it }
    ) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryEditable)
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedText = option
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun LazyVerticalGridExample() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(6) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (index % 2 == 0)
                        MaterialTheme.colorScheme.primaryContainer
                    else
                        MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text("Grid Item $index")
                }
            }
        }
    }
}

@Composable
fun NavigationRailExample() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Home", "Search", "Settings")
    val icons = listOf(Icons.Default.Home, Icons.Default.Search, Icons.Default.Settings)

    Row {
        NavigationRail {
            items.forEachIndexed { index, item ->
                NavigationRailItem(
                    icon = { Icon(icons[index], contentDescription = item) },
                    label = { Text(item) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index }
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("NavigationRail Content Area\nSelected: ${items[selectedItem]}")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldExample() {
    var text by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Label") },
            placeholder = { Text("Placeholder") }
        )

        OutlinedTextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("With Icon") },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
            trailingIcon = { Icon(Icons.Default.Star, contentDescription = null) }
        )
    }
}

@Composable
fun PagerExample() {
    // Simulamos un Pager simple
    var currentPage by remember { mutableIntStateOf(0) }
    val pages = listOf("Page 1", "Page 2", "Page 3")

    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(pages[currentPage], fontSize = 20.sp)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { if (currentPage > 0) currentPage-- },
                enabled = currentPage > 0
            ) {
                Text("Previous")
            }

            Text("${currentPage + 1} / ${pages.size}")

            Button(
                onClick = { if (currentPage < pages.size - 1) currentPage++ },
                enabled = currentPage < pages.size - 1
            ) {
                Text("Next")
            }
        }
    }
}

@Composable
fun SnackbarExample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("Simple Snackbar")
                }
            }
        ) {
            Text("Show Snackbar")
        }

        Button(
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = "Snackbar with Action",
                        actionLabel = "Action"
                    )
                }
            }
        ) {
            Text("Show Snackbar with Action")
        }

        SnackbarHost(hostState = snackbarHostState)
    }
}

@Composable
fun TabRowExample() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")

    Column {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(top = 8.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text("Content for ${tabs[selectedTabIndex]}")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TooltipExample() {
    // Material3 TooltipBox es experimental, simulamos con Card
    var showTooltip by remember { mutableStateOf(false) }

    Column {
        Box {
            Button(
                onClick = { showTooltip = !showTooltip }
            ) {
                Text("Hover/Click for Tooltip")
            }

            if (showTooltip) {
                Card(
                    modifier = Modifier
                        .offset(y = (-40).dp)
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.inverseSurface)
                ) {
                    Text(
                        "This is a tooltip!",
                        modifier = Modifier.padding(8.dp),
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
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

            item {
                ComponentCard("AlertDialog") { AlertDialogExample() }
            }
            item {
                ComponentCard("Card") { CardExample() }
            }
            item {
                ComponentCard("Checkbox") { CheckboxExample() }
            }
            item {
                ComponentCard("FloatingActionButton") { FloatingActionButtonExample() }
            }
            item {
                ComponentCard("Icon") { IconExample() }
            }
            item {
                ComponentCard("Image") { ImageExample() }
            }
            item {
                ComponentCard("ProgressBar") { ProgressBarExample() }
            }
            item {
                ComponentCard("RadioButton") { RadioButtonExample() }
            }
            item {
                ComponentCard("Slider") { SliderExample() }
            }
            item {
                ComponentCard("Spacer") { SpacerExample() }
            }
            item {
                ComponentCard("Switch") { SwitchExample() }
            }
            item {
                ComponentCard("TopAppBar") { TopAppBarExample() }
            }
            item {
                ComponentCard("BottomNavigation") { BottomNavigationExample() }
            }
            item {
                ComponentCard("Dialog") { DialogExample() }
            }
            item {
                ComponentCard("Divider") { DividerExample() }
            }
            item {
                ComponentCard("DropDownMenu") { DropDownMenuExample() }
            }
            item {
                ComponentCard("LazyVerticalGrid") { LazyVerticalGridExample() }
            }
            item {
                ComponentCard("NavigationRail") { NavigationRailExample() }
            }
            item {
                ComponentCard("OutlinedTextField") { OutlinedTextFieldExample() }
            }
            item {
                ComponentCard("Pager") { PagerExample() }
            }
            item {
                ComponentCard("Snackbar") { SnackbarExample() }
            }
            item {
                ComponentCard("TabRow") { TabRowExample() }
            }
            item {
                ComponentCard("Tooltip") { TooltipExample() }
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