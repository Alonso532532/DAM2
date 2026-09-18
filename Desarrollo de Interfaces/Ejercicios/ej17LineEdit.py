from PyQt6.QtWidgets import QApplication, QMainWindow, QLineEdit# Se importa solo lo que necesitas
from PyQt6.QtCore import QSize, Qt

class MainWindow(QMainWindow):
    def __init__(self): # Esto es una función a la que le pasas "self" que es la propia clase ¿constructor?
        super().__init__() # Esto inicializa el objeto
        
        self.setWindowTitle("Mi Aplicación") # Le pongo un titulo

        self.campo = QLineEdit()

        # Parámetros
        self.campo.setMaxLength(20)
        self.campo.setPlaceholderText("Iker Loano Romero")
        
        self.campo.textChanged.connect(self.cambio)
        self.campo.returnPressed.connect(self.introPulsado)

        self.setCentralWidget(self.campo)

    def cambio(self, o):
                print(o)

    def introPulsado(self):
        self.campo.setText("")


app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta