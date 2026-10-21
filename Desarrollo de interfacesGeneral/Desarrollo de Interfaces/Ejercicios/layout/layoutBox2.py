from PyQt6.QtWidgets import QMainWindow, QHBoxLayout, QWidget, QApplication, QVBoxLayout, QCheckBox, QLabel, QLineEdit
from cuadrado import Cuadrado

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 

        self.setWindowTitle("Mi aplicación")

        plantilla = QVBoxLayout()

        plantillah1 = QHBoxLayout()
        plantillav2 = QVBoxLayout()

        plantillah1.addWidget(QLabel("Texto"))
        plantillah1.addWidget(QLineEdit())

        for i in range(3):
            check = QCheckBox(f"Opción {i+1}")
            check.stateChanged.connect(self.dtectar)
            plantillav2.addWidget(check)

        plantilla.addLayout(plantillah1)
        plantilla.addLayout(plantillav2)

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

