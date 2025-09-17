package com.example.lab_03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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

/* ------------------ CONTENEDORES ESTILIZADOS ------------------ */

@Composable
fun LazyColumnExample() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF7FAFC)),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(count = 10) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(2.dp, RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = if (index % 2 == 0) Color(0xFF667eea) else Color(0xFF764ba2)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(Color.White.copy(alpha = 0.3f), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "$index",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "LazyColumn Item $index",
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Composable
fun LazyRowExample() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(count = 6) { index ->
            Card(
                modifier = Modifier
                    .size(100.dp)
                    .shadow(6.dp, RoundedCornerShape(20.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = when (index % 3) {
                        0 -> Color(0xFF667eea)
                        1 -> Color(0xFF764ba2)
                        else -> Color(0xFF4FACFE)
                    }
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "💫",
                        fontSize = 24.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Item $index",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
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
            .height(240.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF7FAFC)),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(9) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .shadow(4.dp, RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF667eea).copy(alpha = 0.8f + (index * 0.02f))
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "🎯",
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "$index",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ConstraintLayoutExample() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .shadow(4.dp, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF667eea)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Card(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("🔝 Top Start", modifier = Modifier.padding(8.dp), fontSize = 12.sp)
            }

            Card(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("🔚 Top End", modifier = Modifier.padding(8.dp), fontSize = 12.sp)
            }

            Card(
                modifier = Modifier.align(Alignment.Center),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("🎯 Center", modifier = Modifier.padding(12.dp), fontWeight = FontWeight.Bold)
            }

            Card(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("⬇️ Bottom", modifier = Modifier.padding(8.dp), fontSize = 12.sp)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
            .shadow(8.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "🏗️ Scaffold Demo",
                            fontWeight = FontWeight.Bold
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF667eea),
                        titleContentColor = Color.White
                    )
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("¡FAB presionado! ✨")
                        }
                    },
                    containerColor = Color(0xFF764ba2)
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
                }
            },
            snackbarHost = { SnackbarHost(snackbarHostState) },
            bottomBar = {
                BottomAppBar(
                    containerColor = Color(0xFF4FACFE)
                ) {
                    Text(
                        "📱 Bottom Bar",
                        modifier = Modifier.padding(16.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFF7FAFC)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "📋 Scaffold Content",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Text(
                            "Padding aplicado automáticamente",
                            fontSize = 12.sp,
                            color = Color(0xFF718096),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SurfaceExample() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        color = Color.Transparent,
        shadowElevation = 0.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .shadow(12.dp, RoundedCornerShape(20.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF764ba2)
            ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF667eea),
                                Color(0xFF764ba2)
                            )
                        )
                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "🌊",
                        fontSize = 32.sp
                    )
                    Text(
                        "Surface Estilizada",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        "Con gradiente y sombras",
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        AssistChip(
            onClick = { },
            label = {
                Text(
                    "✨ Assist",
                    fontWeight = FontWeight.Medium
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Star,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            },
            colors = AssistChipDefaults.assistChipColors(
                containerColor = Color(0xFF667eea).copy(alpha = 0.2f),
                labelColor = Color(0xFF667eea),
                leadingIconContentColor = Color(0xFF667eea)
            ),
        )

        FilterChip(
            selected = false,
            onClick = { },
            label = {
                Text(
                    "🔍 Filter",
                    fontWeight = FontWeight.Medium
                )
            },
            colors = FilterChipDefaults.filterChipColors(
                containerColor = Color(0xFF764ba2).copy(alpha = 0.2f),
                labelColor = Color(0xFF764ba2)
            )
        )

        SuggestionChip(
            onClick = { },
            label = {
                Text(
                    "💡 Tip",
                    fontWeight = FontWeight.Medium
                )
            },
            colors = SuggestionChipDefaults.suggestionChipColors(
                containerColor = Color(0xFF4FACFE).copy(alpha = 0.2f),
                labelColor = Color(0xFF4FACFE)
            )
        )
    }
}

@Composable
fun BackdropScaffoldExample() {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(if (expanded) 0.3f else 0.7f),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF667eea)
            ),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "🎭",
                    fontSize = 32.sp
                )
                Text(
                    "Backdrop Header",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = { expanded = !expanded },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFF667eea)
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        if (expanded) "Contraer" else "Expandir",
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(if (expanded) 0.7f else 0.3f),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "📱 Backdrop Content",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2D3748)
                    )
                    Text(
                        "Área de contenido ${if (expanded) "expandida" else "contraída"}",
                        fontSize = 12.sp,
                        color = Color(0xFF718096),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

/* ------------------ ÚLTIMOS 5 COMPONENTES ESTILIZADOS ------------------ */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldExample() {
    var text by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "📝",
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "Text Fields Modernos",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2D3748)
                )
            }

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Campo Principal") },
                placeholder = { Text("Escribe aquí...") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF667eea),
                    focusedLabelColor = Color(0xFF667eea),
                    cursorColor = Color(0xFF667eea)
                )
            )

            OutlinedTextField(
                value = text2,
                onValueChange = { text2 = it },
                label = { Text("Con Iconos") },
                leadingIcon = {
                    Icon(
                        Icons.Default.Email,
                        contentDescription = null,
                        tint = Color(0xFF764ba2)
                    )
                },
                trailingIcon = {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFD700)
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF764ba2),
                    focusedLabelColor = Color(0xFF764ba2),
                    cursorColor = Color(0xFF764ba2)
                )
            )
        }
    }
}

@Composable
fun PagerExample() {
    var currentPage by remember { mutableIntStateOf(0) }
    val pages = listOf("Página Inicial", "Explorar", "Perfil")
    val pageColors = listOf(
        Color(0xFF667eea),
        Color(0xFF764ba2),
        Color(0xFF4FACFE)
    )
    val pageEmojis = listOf("🏠", "🔍", "👤")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(12.dp, RoundedCornerShape(24.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Contenido principal del pager
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                colors = CardDefaults.cardColors(
                    containerColor = pageColors[currentPage]
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    pageColors[currentPage].copy(alpha = 0.8f),
                                    pageColors[currentPage]
                                ),
                                radius = 300f
                            )
                        )
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = pageEmojis[currentPage],
                            fontSize = 48.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            pages[currentPage],
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }

            // Indicadores de página
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                pages.forEachIndexed { index, _ ->
                    Box(
                        modifier = Modifier
                            .size(
                                width = if (index == currentPage) 24.dp else 8.dp,
                                height = 8.dp
                            )
                            .background(
                                color = if (index == currentPage)
                                    pageColors[currentPage]
                                else
                                    Color(0xFFE2E8F0),
                                shape = RoundedCornerShape(4.dp)
                            )
                    )
                    if (index < pages.size - 1) {
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }
            }

            // Controles de navegación
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { if (currentPage > 0) currentPage-- },
                    enabled = currentPage > 0,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF667eea)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("◀ Anterior", color = Color.White)
                }

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFF7FAFC)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        "${currentPage + 1} / ${pages.size}",
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        fontWeight = FontWeight.Medium
                    )
                }

                Button(
                    onClick = { if (currentPage < pages.size - 1) currentPage++ },
                    enabled = currentPage < pages.size - 1,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF764ba2)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("Siguiente ▶", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun SnackbarExample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "📢",
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "Snackbar Notifications",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2D3748)
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("✨ Notificación simple mostrada!")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF667eea)
                    ),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("💬", fontSize = 16.sp)
                        Text(
                            "Simple",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                }

                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "🎯 Notificación con acción disponible",
                                actionLabel = "ACCIÓN",
                                duration = SnackbarDuration.Long
                            )
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF764ba2)
                    ),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("⚡", fontSize = 16.sp)
                        Text(
                            "Con Acción",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                }
            }

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF7FAFC)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    "Las notificaciones aparecerán en la parte inferior de la pantalla",
                    modifier = Modifier.padding(12.dp),
                    fontSize = 12.sp,
                    color = Color(0xFF718096),
                    textAlign = TextAlign.Center
                )
            }

            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun TabRowExample() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Dashboard", "Analytics", "Settings")
    val tabEmojis = listOf("📊", "📈", "⚙️")
    val tabColors = listOf(
        Color(0xFF667eea),
        Color(0xFF764ba2),
        Color(0xFF4FACFE)
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(12.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column {
            // TabRow personalizada
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF7FAFC)
                ),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ) {
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    containerColor = Color.Transparent,
                    indicator = { tabPositions ->
                        Box(
                            modifier = Modifier
                                 .height(4.dp)
                                .padding(horizontal = 16.dp)
                                .background(
                                    tabColors[selectedTabIndex],
                                    RoundedCornerShape(2.dp)
                                )
                        )
                    }
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            modifier = Modifier.padding(vertical = 8.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(vertical = 8.dp)
                            ) {
                                Text(
                                    text = tabEmojis[index],
                                    fontSize = 20.sp
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    title,
                                    fontWeight = if (selectedTabIndex == index)
                                        FontWeight.Bold
                                    else
                                        FontWeight.Normal,
                                    color = if (selectedTabIndex == index)
                                        tabColors[index]
                                    else
                                        Color(0xFF718096),
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }
            }

            // Contenido de la tab seleccionada
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                colors = CardDefaults.cardColors(
                    containerColor = tabColors[selectedTabIndex].copy(alpha = 0.1f)
                ),
                shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = tabColors[selectedTabIndex]
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                text = tabEmojis[selectedTabIndex],
                                fontSize = 32.sp,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            "Contenido para ${tabs[selectedTabIndex]}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = tabColors[selectedTabIndex]
                        )
                        Text(
                            "Esta es la vista de la pestaña seleccionada",
                            fontSize = 12.sp,
                            color = Color(0xFF718096),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TooltipExample() {
    var showTooltip by remember { mutableStateOf(false) }
    var showAdvancedTooltip by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "💬",
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "Interactive Tooltips",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2D3748)
                )
            }

            // Tooltip simple
            Box {
                Button(
                    onClick = { showTooltip = !showTooltip },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF667eea)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("💡", fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Tooltip Simple", color = Color.White)
                    }
                }

                if (showTooltip) {
                    Card(
                        modifier = Modifier
                            .offset(y = (-60).dp)
                            .shadow(8.dp, RoundedCornerShape(12.dp)),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF2D3748)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            "✨ Este es un tooltip informativo!",
                            modifier = Modifier.padding(12.dp),
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            // Tooltip avanzado
            Box {
                Button(
                    onClick = { showAdvancedTooltip = !showAdvancedTooltip },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF764ba2)
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("🚀", fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Tooltip Avanzado", color = Color.White)
                    }
                }

                if (showAdvancedTooltip) {
                    Card(
                        modifier = Modifier
                            .offset(y = (-100).dp)
                            .width(200.dp)
                            .shadow(12.dp, RoundedCornerShape(16.dp)),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("🎯", fontSize = 20.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "Tooltip Pro",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Color(0xFF2D3748)
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                "Este tooltip tiene más información y un diseño más elaborado con múltiples elementos.",
                                fontSize = 12.sp,
                                color = Color(0xFF718096),
                                lineHeight = 16.sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(
                                onClick = { showAdvancedTooltip = false },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF764ba2)
                                ),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    "Entendido",
                                    fontSize = 12.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }

            // Info card
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF0F9FF)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("ℹ️", fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Haz clic en los botones para mostrar/ocultar los tooltips",
                        fontSize = 12.sp,
                        color = Color(0xFF0369A1)
                    )
                }
            }
        }
    }
}

/* ------------------ COMPONENTE PRINCIPAL SHOWCASE ------------------ */

@Composable
fun ComponentShowcase() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF667eea),
                        Color(0xFF764ba2)
                    )
                )
            )
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            item {
                // Header principal
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(12.dp, RoundedCornerShape(24.dp)),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "🎨",
                            fontSize = 48.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Component Showcase",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF2D3748),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Explore beautiful Material Design components",
                            fontSize = 14.sp,
                            color = Color(0xFF718096),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            // CONTENEDORES
            item { ComponentSection("📋 CONTENEDORES", Color(0xFF667eea)) { LazyColumnExample() } }
            item { ComponentSection("➡️ LAZY ROW", Color(0xFF764ba2)) { LazyRowExample() } }
            item { ComponentSection("⚡ GRID LAYOUT", Color(0xFF667eea)) { GridExample() } }
            item { ComponentSection("📍 CONSTRAINT", Color(0xFF764ba2)) { ConstraintLayoutExample() } }
            item { ComponentSection("🏗️ SCAFFOLD", Color(0xFF667eea)) { ScaffoldExample() } }
            item { ComponentSection("🌊 SURFACE", Color(0xFF764ba2)) { SurfaceExample() } }
            item { ComponentSection("🏷️ CHIPS", Color(0xFF667eea)) { ChipExample() } }
            item { ComponentSection("🎭 BACKDROP", Color(0xFF764ba2)) { BackdropScaffoldExample() } }
            item { ComponentSection("🌊 FLOW ROW", Color(0xFF667eea)) { FlowRowExample() } }
            item { ComponentSection("📊 FLOW COLUMN", Color(0xFF764ba2)) { FlowColumnExample() } }

            // CONTROLES
            item { ComponentSection("🚨 ALERT DIALOG", Color(0xFF667eea)) { AlertDialogExample() } }
            item { ComponentSection("🎴 CARDS", Color(0xFF764ba2)) { CardExample() } }
            item { ComponentSection("☑️ CHECKBOX", Color(0xFF667eea)) { CheckboxExample() } }
            item { ComponentSection("🎈 FAB", Color(0xFF764ba2)) { FloatingActionButtonExample() } }
            item { ComponentSection("🎨 ICONS", Color(0xFF667eea)) { IconExample() } }
            item { ComponentSection("🖼️ IMAGES", Color(0xFF764ba2)) { ImageExample() } }
            item { ComponentSection("📊 PROGRESS", Color(0xFF667eea)) { ProgressBarExample() } }
            item { ComponentSection("📻 RADIO", Color(0xFF764ba2)) { RadioButtonExample() } }
            item { ComponentSection("🎚️ SLIDER", Color(0xFF667eea)) { SliderExample() } }
            item { ComponentSection("📏 SPACER", Color(0xFF764ba2)) { SpacerExample() } }
            item { ComponentSection("🔘 SWITCH", Color(0xFF667eea)) { SwitchExample() } }
            item { ComponentSection("🔝 TOP BAR", Color(0xFF764ba2)) { TopAppBarExample() } }
            item { ComponentSection("📱 BOTTOM NAV", Color(0xFF667eea)) { BottomNavigationExample() } }
            item { ComponentSection("💬 DIALOG", Color(0xFF764ba2)) { DialogExample() } }
            item { ComponentSection("📏 DIVIDER", Color(0xFF667eea)) { DividerExample() } }
            item { ComponentSection("📋 DROPDOWN", Color(0xFF764ba2)) { DropDownMenuExample() } }
            item { ComponentSection("🔲 GRID", Color(0xFF667eea)) { LazyVerticalGridExample() } }
            item { ComponentSection("🚈 NAV RAIL", Color(0xFF764ba2)) { NavigationRailExample() } }
            item { ComponentSection("📝 TEXT FIELD", Color(0xFF667eea)) { OutlinedTextFieldExample() } }
            item { ComponentSection("📄 PAGER", Color(0xFF764ba2)) { PagerExample() } }
            item { ComponentSection("📢 SNACKBAR", Color(0xFF667eea)) { SnackbarExample() } }
            item { ComponentSection("📑 TABS", Color(0xFF764ba2)) { TabRowExample() } }
            item { ComponentSection("💬 TOOLTIP", Color(0xFF667eea)) { TooltipExample() } }
        }
    }
}

@Composable
fun ComponentSection(title: String, accentColor: Color, content: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            // Header de sección
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .background(accentColor, CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2D3748)
                )
            }

            // Contenido del componente
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

@Composable
fun FlowRowExample() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(3) { index ->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF667eea).copy(alpha = 0.8f + index * 0.1f)
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        "🌊 Item $index",
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(2) { index ->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF764ba2).copy(alpha = 0.8f + index * 0.1f)
                    ),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(
                        "✨ Item ${index + 3}",
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
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
        Card(
            modifier = Modifier.weight(1f),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF7FAFC)
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    "📊 Col 1:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFF2D3748)
                )
                repeat(3) { index ->
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF667eea).copy(alpha = 0.7f + index * 0.1f)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            "A$index",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 12.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }

        Card(
            modifier = Modifier.weight(1f),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF7FAFC)
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    "📈 Col 2:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFF2D3748)
                )
                repeat(2) { index ->
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF764ba2).copy(alpha = 0.7f + index * 0.1f)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            "B$index",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 12.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

/* ------------------ CONTROLES ESTILIZADOS ------------------ */

@Composable
fun AlertDialogExample() {
    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "🚨",
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "Alert Dialog Demo",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2D3748)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { showDialog = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF667eea)
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Mostrar AlertDialog", color = Color.White)
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = {
                        Text(
                            "🔔 Confirmación",
                            fontWeight = FontWeight.Bold
                        )
                    },
                    text = {
                        Text(
                            "Este es un ejemplo de AlertDialog con estilo personalizado. ¿Deseas continuar?",
                            color = Color(0xFF718096)
                        )
                    },
                    confirmButton = {
                        Button(
                            onClick = { showDialog = false },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF667eea)
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("✅ Confirmar")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = { showDialog = false }
                        ) {
                            Text(
                                "❌ Cancelar",
                                color = Color(0xFF718096)
                            )
                        }
                    },
                    shape = RoundedCornerShape(20.dp)
                )
            }
        }
    }
}

@Composable
fun CardExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .weight(1f)
                .height(120.dp)
                .shadow(6.dp, RoundedCornerShape(20.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF667eea)
            ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "🎨",
                    fontSize = 32.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Card 1",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        Card(
            modifier = Modifier
                .weight(1f)
                .height(120.dp)
                .shadow(8.dp, RoundedCornerShape(20.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF764ba2)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "🚀",
                    fontSize = 32.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Card 2",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun CheckboxExample() {
    var checked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(6.dp, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = if (checked) "✅" else "⭕",
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.width(12.dp))
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF667eea),
                    uncheckedColor = Color(0xFF718096)
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Checkbox ${if (checked) "Activado" else "Desactivado"}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = if (checked) Color(0xFF667eea) else Color(0xFF718096)
            )
        }
    }
}

@Composable
fun FloatingActionButtonExample() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "🎈 Floating Action Buttons",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2D3748)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FloatingActionButton(
                    onClick = { },
                    modifier = Modifier.size(56.dp),
                    containerColor = Color(0xFF667eea),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White
                    )
                }

                ExtendedFloatingActionButton(
                    onClick = { },
                    icon = {
                        Icon(
                            Icons.Default.Edit,
                            contentDescription = null,
                            tint = Color.White
                        )
                    },
                    text = {
                        Text(
                            "Extended FAB",
                            color = Color.White,
                            fontWeight = FontWeight.Medium
                        )
                    },
                    containerColor = Color(0xFF764ba2),
                    shape = RoundedCornerShape(20.dp)
                )
            }
        }
    }
}

@Composable
fun IconExample() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(6.dp, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                "🎨 Icon Gallery",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2D3748)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Favorite",
                        tint = Color(0xFFE53E3E),
                        modifier = Modifier.size(32.dp)
                    )
                    Text("Favorite", fontSize = 12.sp, color = Color(0xFF718096))
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = "Star",
                        tint = Color(0xFFFFD700),
                        modifier = Modifier.size(32.dp)
                    )
                    Text("Star", fontSize = 12.sp, color = Color(0xFF718096))
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Home",
                        tint = Color(0xFF667eea),
                        modifier = Modifier.size(32.dp)
                    )
                    Text("Home", fontSize = 12.sp, color = Color(0xFF718096))
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = Color(0xFF764ba2),
                        modifier = Modifier.size(32.dp)
                    )
                    Text("Settings", fontSize = 12.sp, color = Color(0xFF718096))
                }
            }
        }
    }
}

@Composable
fun ImageExample() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .shadow(6.dp, RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF667eea)
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = "Image placeholder",
                        modifier = Modifier.size(40.dp),
                        tint = Color.White
                    )
                    Text(
                        "Imagen 1",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .shadow(6.dp, RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF764ba2)
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Imagen 2",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Composable
fun ProgressBarExample() {
    var progress by remember { mutableFloatStateOf(0.3f) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "📊 Progress Indicators",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2D3748)
            )

            Text(
                "Progreso: ${(progress * 100).toInt()}%",
                fontSize = 14.sp,
                color = Color(0xFF718096)
            )

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF667eea),
                trackColor = Color(0xFFE2E8F0)
            )

            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF764ba2),
                trackColor = Color(0xFFE2E8F0)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                CircularProgressIndicator(
                    progress = { progress },
                    color = Color(0xFF667eea),
                    trackColor = Color(0xFFE2E8F0),
                    modifier = Modifier.size(48.dp)
                )
                CircularProgressIndicator(
                    color = Color(0xFF764ba2),
                    trackColor = Color(0xFFE2E8F0),
                    modifier = Modifier.size(48.dp)
                )
            }

            Button(
                onClick = { progress = if (progress >= 1f) 0f else progress + 0.1f },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4FACFE)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Actualizar Progreso", color = Color.White)
            }
        }
    }
}

@Composable
fun RadioButtonExample() {
    val options = listOf("Opción Premium", "Opción Estándar", "Opción Básica")
    val optionEmojis = listOf("⭐", "🎯", "📦")
    var selectedOption by remember { mutableStateOf(options[0]) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                "📻 Radio Button Selection",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2D3748)
            )

            Spacer(modifier = Modifier.height(16.dp))

            options.forEachIndexed { index, option ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (selectedOption == option)
                            Color(0xFF667eea).copy(alpha = 0.1f)
                        else
                            Color(0xFFF7FAFC)
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = optionEmojis[index],
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        RadioButton(
                            selected = selectedOption == option,
                            onClick = { selectedOption = option },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF667eea),
                                unselectedColor = Color(0xFF718096)
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            option,
                            fontWeight = if (selectedOption == option)
                                FontWeight.Bold
                            else
                                FontWeight.Normal,
                            color = if (selectedOption == option)
                                Color(0xFF667eea)
                            else
                                Color(0xFF718096)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SliderExample() {
    var sliderValue by remember { mutableFloatStateOf(50f) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "🎚️",
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "Slider Control",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2D3748)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF667eea).copy(alpha = 0.1f)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    "Valor actual: ${sliderValue.toInt()}",
                    modifier = Modifier.padding(12.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF667eea)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                valueRange = 0f..100f,
                modifier = Modifier.fillMaxWidth(),
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xFF667eea),
                    activeTrackColor = Color(0xFF667eea),
                    inactiveTrackColor = Color(0xFFE2E8F0)
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("0", fontSize = 12.sp, color = Color(0xFF718096))
                Text("50", fontSize = 12.sp, color = Color(0xFF718096))
                Text("100", fontSize = 12.sp, color = Color(0xFF718096))
            }
        }
    }
}

@Composable
fun SpacerExample() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(6.dp, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                "📏 Spacer Demo",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2D3748)
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF667eea)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Texto superior",
                    modifier = Modifier.padding(8.dp),
                    color = Color.White,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF764ba2)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Después del Spacer (24dp)",
                    modifier = Modifier.padding(8.dp),
                    color = Color.White,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF4FACFE)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Spacer menor (8dp)",
                    modifier = Modifier.padding(8.dp),
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun SwitchExample() {
    var checked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(6.dp, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = if (checked) "🟢" else "⚫",
                fontSize = 24.sp
            )
            Switch(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF667eea),
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color(0xFF718096)
                )
            )
            Text(
                "Switch está ${if (checked) "ACTIVADO" else "DESACTIVADO"}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = if (checked) Color(0xFF667eea) else Color(0xFF718096)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp)
    ) {
        TopAppBar(
            title = {
                Text(
                    "🔝 TopAppBar Demo",
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Default.MoreVert,
                        contentDescription = "More",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF667eea),
                titleContentColor = Color.White
            )
        )
    }
}

@Composable
fun BottomNavigationExample() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Inicio", "Buscar", "Perfil")
    val icons = listOf(Icons.Default.Home, Icons.Default.Search, Icons.Default.Person)
    val itemEmojis = listOf("🏠", "🔍", "👤")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    ) {
        NavigationBar(
            containerColor = Color.White
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(itemEmojis[index], fontSize = 20.sp)
                            Icon(
                                icons[index],
                                contentDescription = item,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    },
                    label = {
                        Text(
                            item,
                            fontSize = 12.sp,
                            fontWeight = if (selectedItem == index)
                                FontWeight.Bold
                            else
                                FontWeight.Normal
                        )
                    },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF667eea),
                        selectedTextColor = Color(0xFF667eea),
                        unselectedIconColor = Color(0xFF718096),
                        unselectedTextColor = Color(0xFF718096),
                        indicatorColor = Color(0xFF667eea).copy(alpha = 0.1f)
                    )
                )
            }
        }
    }
}

@Composable
fun DialogExample() {
    var showDialog by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "💬 Custom Dialog",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2D3748)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { showDialog = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF764ba2)
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Mostrar Dialog Personalizado", color = Color.White)
            }

            if (showDialog) {
                Dialog(onDismissRequest = { showDialog = false }) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(16.dp, RoundedCornerShape(24.dp)),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(
                                "🎉",
                                fontSize = 48.sp
                            )
                            Text(
                                "Dialog Personalizado",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF2D3748)
                            )
                            Text(
                                "Este es el contenido de un dialog completamente personalizado con diseño moderno.",
                                fontSize = 14.sp,
                                color = Color(0xFF718096),
                                textAlign = TextAlign.Center
                            )
                            Button(
                                onClick = { showDialog = false },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF764ba2)
                                ),
                                shape = RoundedCornerShape(16.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Cerrar Dialog", color = Color.White)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DividerExample() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(6.dp, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                "📏 Divider Styles",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2D3748)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF7FAFC)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Sección Superior",
                    modifier = Modifier.padding(12.dp),
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF2D3748)
                )
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 12.dp),
                thickness = 1.dp,
                color = Color(0xFFE2E8F0)
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF0F9FF)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Sección Media",
                    modifier = Modifier.padding(12.dp),
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF2D3748)
                )
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 12.dp),
                thickness = 3.dp,
                color = Color(0xFF667eea)
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFDF2F8)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Sección Inferior",
                    modifier = Modifier.padding(12.dp),
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF2D3748)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenuExample() {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Seleccionar Opción") }
    val options = listOf("Opción Premium ⭐", "Opción Estándar 🎯", "Opción Básica 📦", "Opción Gratuita 🆓")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                "📋 Dropdown Menu",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2D3748)
            )

            Spacer(modifier = Modifier.height(16.dp))

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = it }
            ) {
                OutlinedTextField(
                    value = selectedText,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    modifier = Modifier
                        .menuAnchor(MenuAnchorType.PrimaryEditable)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF667eea),
                        unfocusedBorderColor = Color(0xFFE2E8F0)
                    )
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    option,
                                    fontSize = 14.sp,
                                    color = Color(0xFF2D3748)
                                )
                            },
                            onClick = {
                                selectedText = option
                                expanded = false
                            }
                        )
                    }
                }
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
            .height(200.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF7FAFC)),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(6) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .shadow(4.dp, RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = if (index % 2 == 0)
                        Color(0xFF667eea)
                    else
                        Color(0xFF764ba2)
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "📱",
                        fontSize = 24.sp
                    )
                    Text(
                        "Grid Item $index",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
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
    val itemEmojis = listOf("🏠", "🔍", "⚙️")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .shadow(8.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row {
            NavigationRail(
                containerColor = Color.White
            ) {
                items.forEachIndexed { index, item ->
                    NavigationRailItem(
                        icon = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(itemEmojis[index], fontSize = 16.sp)
                                Icon(
                                    icons[index],
                                    contentDescription = item,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        },
                        label = {
                            Text(
                                item,
                                fontSize = 10.sp,
                                fontWeight = if (selectedItem == index)
                                    FontWeight.Bold
                                else
                                    FontWeight.Normal
                            )
                        },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        colors = NavigationRailItemDefaults.colors(
                            selectedIconColor = Color(0xFF667eea),
                            selectedTextColor = Color(0xFF667eea),
                            unselectedIconColor = Color(0xFF718096),
                            unselectedTextColor = Color(0xFF718096),
                            indicatorColor = Color(0xFF667eea).copy(alpha = 0.1f)
                        )
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF7FAFC))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        itemEmojis[selectedItem],
                        fontSize = 32.sp
                    )
                    Text(
                        "NavigationRail Content",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color(0xFF2D3748)
                    )
                    Text(
                        "Seleccionado: ${items[selectedItem]}",
                        fontSize = 12.sp,
                        color = Color(0xFF718096)
                    )
                }
            }
        }
    }
}