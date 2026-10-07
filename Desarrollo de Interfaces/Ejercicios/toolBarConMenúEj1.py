from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize
from cuadrado import Cuadrado  

class MainWindow(QMainWindow):
    cont = 0

    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        self.label = QLabel("Hola")

        self.label.setAlignment(Qt.AlignmentFlag.AlignCenter)

        self.setCentralWidget(self.label)

        barra = QToolBar("Barra de herramientas")

        # Boton Se añadirá luego en el menú ===========================================================================================>

        # Le añado un icono pero se carga el texto de "Botón"
        boton = QAction(QIcon("Ejercicios/fugue-icons-3.5.6/icons/bug.png"),"Cambiar texto", self)

        # Para añadirle un texto que salga al hacer hover, pero se tiene que añadir más abajo "self.setStatusBar(QStatusBar(self))"
        boton.setStatusTip("Botón para cambiar el texto")
        boton.triggered.connect(self.botonpulsado)

        barra.addAction(boton)

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
        menuArchivo.addSeparator()



    def botonpulsado(self):
        self.cont+=1
        self.label.setText(f"Texto cambiado {self.cont}")

# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
