from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar, QDialog
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize
from cuadrado import Cuadrado  

class MainWindow(QMainWindow):
    cont = 0

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación")

        boton = QPushButton("Dialogo")

        boton.clicked.connect(self.pulsado)

        self.setCentralWidget(boton)
        
    def pulsado(self, s):
        # Un dialogo para la ventana
        # Aquí al especificarle shelf le estoy diciendo quien es su padre para que salga con un tamaño razonable
        dlg = QDialog(self)
        dlg.setWindowTitle("Cuadro de dialogo")
        dlg.exec()

# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
