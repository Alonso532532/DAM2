from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize
from cuadrado import Cuadrado  

class MainWindow(QMainWindow):
    cont = 0

    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        # Construyo la interfáz principal ============================================================================================>
        self.label = QLabel("Hola!")

        # self.label.setAlignment(Qt.AlignmentFlag.AlignCenter)

        self.setCentralWidget(self.label)

        barra = QToolBar("Barra de herramientas")

        # Boton Se añadirá luego en el menú ===========================================================================================>

        # Le añado un icono pero se carga el texto de "Botón"
        boton = QAction(QIcon("Ejercicios/fugue-icons-3.5.6/icons/disk.png"),"Guardar", self)

        # Para añadirle un texto que salga al hacer hover, pero se tiene que añadir más abajo "self.setStatusBar(QStatusBar(self))"
        boton.setStatusTip("Guardar doucmento")
        boton.triggered.connect(self.botonGuardarPulsado)

        barra.addAction(boton)

        # Boton2 Se añadirá luego en el menú ===========================================================================================>

        # Le añado un icono pero se carga el texto de "Botón"
        boton2 = QAction(QIcon("Ejercicios/fugue-icons-3.5.6/icons/document.png"),"Nuevo", self)

        # Para añadirle un texto que salga al hacer hover, pero se tiene que añadir más abajo "self.setStatusBar(QStatusBar(self))"
        boton2.setStatusTip("Nuevo doucmento")
        boton2.triggered.connect(self.botonNuevoPulsado)

        barra.addAction(boton2)

        # Boton3 Se añadirá luego en el menú ===========================================================================================>

        # Le añado un icono pero se carga el texto de "Botón"
        boton3 = QAction(QIcon("Ejercicios/fugue-icons-3.5.6/icons/application-dock.png"),"Abrir", self)

        # Para añadirle un texto que salga al hacer hover, pero se tiene que añadir más abajo "self.setStatusBar(QStatusBar(self))"
        boton3.setStatusTip("Abrir doucmento")
        boton3.triggered.connect(self.botonAbrirPulsado)

        barra.addAction(boton3)

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

        # Le añado una de las funciónes creadas anteriormente
        menuArchivo.addAction(boton)
        menuArchivo.addAction(boton2)
        menuArchivo.addAction(boton3)
        #menuArchivo.addSeparator()

        # Boton4 Se añadirá luego en el menú ===========================================================================================>

        # Le añado un icono pero se carga el texto de "Botón"
        boton4 = QAction("X", self)

        # Para añadirle un texto que salga al hacer hover, pero se tiene que añadir más abajo "self.setStatusBar(QStatusBar(self))"
        boton4.setStatusTip("Síguenos en Tweeter")

        # Boton5 Se añadirá luego en el menú ===========================================================================================>

        # Le añado un icono pero se carga el texto de "Botón"
        boton5 = QAction("Instagram", self)

        # Para añadirle un texto que salga al hacer hover, pero se tiene que añadir más abajo "self.setStatusBar(QStatusBar(self))"
        boton5.setStatusTip("Síguenos en Instagram")

        # Menu2 ===========================================================================================>

        menu2 = self.menuBar()
        # El "&" hace que al presionar "Alt" se seleccióne
        menuArchivo = menu2.addMenu("&Ayuda")

        # Le añado una de las funciónes creadas anteriormente
        submenu = menuArchivo.addMenu("Síguenos")
        submenu.addAction(boton4)
        submenu.addAction(boton5)
        # menuArchivo.addSeparator()
        
    def botonGuardarPulsado(self, s):
        self.label.setText("Guardar")

    def botonNuevoPulsado(self, s):
        self.label.setText("Nuevo")

    def botonAbrirPulsado(self, s):
        self.label.setText("Abrir")

# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
