from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QLabel, QLineEdit, QVBoxLayout, QWidget# Se importa solo lo que necesitas
from PyQt6.QtCore import QSize, Qt

class MainWindow(QMainWindow):
    def __init__(self): # Esto es una función a la que le pasas "self" que es la propia clase ¿constructor?
        super().__init__() # Esto inicializa el objeto
        
        self.setWindowTitle("Mi Aplicación") # Le pongo un titulo

        # Creo los elementos
        label = QLabel()
        input = QLineEdit() 

        # hago que lo que se escriba se escriba en el label, si se pone una función sin "()" se envian elementos de alguna forma
        input.textChanged.connect(label.setText)

        # Hago el layout vertical para poner varios elementos
        layout = QVBoxLayout()

        # Añado los elementos al layout
        layout.addWidget(label)
        layout.addWidget(input)

        # Hace un widget al que se le pone el layout que posteriormente se añadirá a la interfaz
        contenedor = QWidget()
        contenedor.setLayout(layout)

        self.setCentralWidget(contenedor)


app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta