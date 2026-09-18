from PyQt6.QtWidgets import QApplication, QMainWindow, QComboBox, QListWidget,  # Se importa solo lo que necesitas
from PyQt6.QtCore import QSize, Qt

class MainWindow(QMainWindow):
    def __init__(self): # Esto es una función a la que le pasas "self" que es la propia clase ¿constructor?
        super().__init__() # Esto inicializa el objeto
        
        self.setWindowTitle("Mi Aplicación") # Le pongo un titulo

        lista = QListWidget()
        lista.addItems(["Uno","Dos","Tres"])

        lista.currentTextChanged.connect(self.mandarOp)

        # Para habilitar la selección multiple y hay que importar el paquete QAbstractItemView
        lista.setSelectionMode(QAbstractItemView.SelectionMode.MultiSelection)

        self.setCentralWidget(lista)

    def mandarOp(self, o):
        print(o)

app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta