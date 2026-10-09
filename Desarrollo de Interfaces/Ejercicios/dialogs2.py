from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar, QDialog
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize
from cuadrado import Cuadrado  
from dialogs import CustomDialog

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación")

        boton = QPushButton("Dialogo")

        boton.clicked.connect(self.pulsado)

        self.setCentralWidget(boton)
        
    def pulsado(self, s):
        # Aquí al especificarle shelf le estoy diciendo quien es su padre para que salga con un tamaño razonable
        dlg = CustomDialog(self)
        if dlg.exec():
            print("El usuario ha aceptado")
        else:
            print("El usuario ha rechazado")

# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
