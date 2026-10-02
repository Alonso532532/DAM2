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

        # Botón para barras
        boton = QAction("Botón", self)
        # Para añadirle un texto que salga al hacer hover, pero se tiene que añadir más abajo "self.setStatusBar(QStatusBar(self))"
        boton.setStatusTip("Este es mi botón")
        boton.triggered.connect(self.botonpulsado)

        barra.addAction(boton)

        self.addToolBar(barra)
        self.setStatusBar(QStatusBar(self))

    def botonpulsado(self, s):
        print(s)

# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
