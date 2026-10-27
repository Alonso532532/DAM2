from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar, QDialog, QMessageBox
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize


class OtraVentana(QWidget):
    def __init__(self):
        super().__init__()

        plantilla = QVBoxLayout()
        self.etiqueta = QLabel()
        plantilla.addWidget(self.etiqueta)
        self.setLayout(plantilla)

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        # Para hacer una ventana persistente
        self.window = OtraVentana()

        self.setWindowTitle("Mi aplicación")

        self.boton = QPushButton("Dialogo")
        self.boton.clicked.connect(self.mostrarVentana)

        self.input = QLineEdit()

        self.input.textChanged.connect(self.window.etiqueta.setText)

        plantilla = QVBoxLayout()
        plantilla.addWidget(self.boton)
        plantilla.addWidget(self.input)

        contenedor = QWidget()
        contenedor.setLayout(plantilla)

        self.setCentralWidget(contenedor)
        
    def mostrarVentana(self):
        if self.window.isVisible():
            self.window.hide()
        else:
            self.window.show()

            


        




# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
