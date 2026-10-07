from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize
from cuadrado import Cuadrado  

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        label = QLabel("Hola")

        label.setAlignment(Qt.AlignmentFlag.AlignCenter)

        self.setCentralWidget(label)

        barra = QToolBar("Barra de herramientas")

        # Boton Se añadirá luego en el menú ===========================================================================================>

        # Botón para barras
        # Le añado un icono pero se carga el texto de "Botón"
        boton = QAction(QIcon("Ejercicios/fugue-icons-3.5.6/icons/smiley-money.png"),"Botón", self)

        # Para añadirle un texto que salga al hacer hover, pero se tiene que añadir más abajo "self.setStatusBar(QStatusBar(self))"
        boton.setStatusTip("Este es mi botón")
        boton.triggered.connect(self.botonpulsado)

        barra.addAction(boton)

        barra.addSeparator()
        
        # Boton 2 Se añadirá luego en el menú ===========================================================================================>

        boton2 = QAction(QIcon("Ejercicios/fugue-icons-3.5.6/icons/smiley-sad.png"),"Botón2", self)

        # Para añadirle un texto que salga al hacer hover, pero se tiene que añadir más abajo "self.setStatusBar(QStatusBar(self))"
        boton2.setStatusTip("Este es mi otro botón")
        boton2.triggered.connect(self.botonpulsado)

        barra.addAction(boton2)

        # Widgets Solo quieres que estén en la barra de herramientas ===========================================================================================>

        barra.addWidget(QLabel("Textico"))
        barra.addWidget(QCheckBox("Iker"))

        # Barra ===========================================================================================>
        # Añado la barra
        self.addToolBar(barra)
        # Le añado un tamaño al icono
        barra.setIconSize(QSize(16,16))

        self.setStatusBar(QStatusBar(self))

        # Menu ===========================================================================================>

        menu = self.menuBar()
        # El "&" hace que al presionar "Alt" se seleccióne
        menuArchivo = menu.addMenu("&Archivo")
        menuEditar = menu.addMenu("&Editar")
        menuInsertar = menu.addMenu("&Insertar")
        # Le añado una de las funciónes creadas anteriormente
        menuArchivo.addAction(boton)
        menuArchivo.addAction(boton2)
        menuArchivo.addSeparator()
        
        # Añado un submenú con más opciónes
        #menuArchivo.addMenu("Más")

        menuMas=menuArchivo.addMenu("Más")
        menuMas.addAction(boton)
        menuMas.addAction(boton2)



    def botonpulsado(self, s):
        print(s)

# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
