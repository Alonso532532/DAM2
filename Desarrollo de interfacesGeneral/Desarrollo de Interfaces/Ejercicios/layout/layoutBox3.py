from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QCheckBox, QLabel, QLineEdit, QPushButton
from cuadrado import Cuadrado

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 

        self.setWindowTitle("Mi aplicación")

        plantilla = QVBoxLayout()

        plantillah1 = QHBoxLayout()

        plantillah1.addWidget(QPushButton("Botón 1"))
        plantillah1.addWidget(QPushButton("Botón 2"))

        plantilla.addLayout(plantillah1)
        plantilla.addWidget(QPushButton("Botón 3"))

        # Para aplicar un layout es necesario un widget
        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)

    def dtectar(self, estado):
        print(f"El estado de la {self.sender().text()} está en {["Activado", "", "Desactivado"][estado]}")
        

app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta

