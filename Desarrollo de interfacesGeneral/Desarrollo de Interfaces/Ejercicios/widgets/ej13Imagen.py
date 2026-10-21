from PyQt6.QtWidgets import QApplication, QMainWindow, QLabel# Se importa solo lo que necesitas
from PyQt6.QtGui import QPixmap
from PyQt6.QtCore import QSize, Qt

class MainWindow(QMainWindow):
    def __init__(self): # Esto es una función a la que le pasas "self" que es la propia clase ¿constructor?
        super().__init__() # Esto inicializa el objeto
        
        self.setWindowTitle("Mi Aplicación") # Le pongo un titulo

        label = QLabel()
        label.setPixmap(QPixmap("Imagen/imagen.png"))

        # Para hacer que la ventana se escale sola
        label.setScaledContents(True)
        label.setMinimumHeight(1)
        
        self.setCentralWidget(label)

app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta