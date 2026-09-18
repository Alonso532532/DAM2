from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget# Se importa solo lo que necesitas
from PyQt6.QtCore import QSize, Qt

class MainWindow(QMainWindow):
    def __init__(self): # Esto es una función a la que le pasas "self" que es la propia clase ¿constructor?
        super().__init__() # Esto inicializa el objeto
        
        self.setWindowTitle("Mi Aplicación") # Le pongo un titulo

        # Creo los elementos
        label = QLabel("Hola")

        # Creo un formato
        formato = label.font()
        formato.setPointSize(20)
        formato.setFamily("Arial")
        formato.setBold(True)

        # Lo sitúo, se pueden combinar
        label.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignTop)
        label.setFont(formato)

        self.setCentralWidget(label)

app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta