from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar, QDialog, QMessageBox
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize
from cuadrado import Cuadrado  

class OtraVentana(QWidget):
    def __init__(self):
        super().__init__()

        plantilla = QVBoxLayout()
        self.etiqueta = QLabel("Otra ventana")
        plantilla.addWidget(self.etiqueta)
        self.setLayout(plantilla)

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación")

        boton = QPushButton("Dialogo")

        boton.clicked.connect(self.mostrarVentana)

        self.setCentralWidget(boton)
        
    def mostrarVentana(self, s):
        # Creo la ventana con el nombre de la "MainWindow"
        self.window = OtraVentana()
        self.window.show()



# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
