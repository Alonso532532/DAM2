from PyQt6.QtWidgets import QMainWindow, QSpinBox, QSpacerItem, QGroupBox, QGridLayout, QRadioButton, QMessageBox, QDateEdit, QComboBox, QHBoxLayout, QTextEdit, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar
from PyQt6.QtGui import QAction, QIcon
from PyQt6.QtCore import Qt, QSize, QDate

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 
        # ====================== Layout padre ====================== 

        layoutPadre = QVBoxLayout()

        # ====================== Titulo ====================== 

        titulo = QLabel("ENTRADAS")
        titulo.setAlignment(Qt.AlignmentFlag.AlignCenter)

        layoutPadre.addWidget(titulo)

        # ====================== Nombre Y Edad ====================== 

        comentario = QLabel("<< Enter para aplicar los cambios >>")
        comentario.setAlignment(Qt.AlignmentFlag.AlignCenter)

        layoutNombre = QHBoxLayout()

        nombreLabel = QLabel("Nombre: ")
        self.nombreEdit = QLineEdit()
        self.nombreEdit.setPlaceholderText("Nombre del comprador")

        layoutNombre.addWidget(nombreLabel)
        layoutNombre.addWidget(self.nombreEdit,1)
        
        layoutEdad = QHBoxLayout()

        self.edadLabel = QLabel("Edad: ")
        self.edadEdit = QSpinBox()

        self.nombreEdit.returnPressed.connect(self.actualizarTexto)
        self.edadEdit.valueChanged.connect(self.actualizarTexto)

        layoutEdad.addWidget(self.edadLabel)
        layoutEdad.addWidget(self.edadEdit,1)

        layoutContenedorDatosPersonales = QVBoxLayout()

        layoutContenedorDatosPersonales.addWidget(comentario)
        layoutContenedorDatosPersonales.addLayout(layoutNombre)
        layoutContenedorDatosPersonales.addLayout(layoutEdad)

        datosPersonales = QGroupBox()
        datosPersonales.setTitle("Datos personales")

        datosPersonales.setLayout(layoutContenedorDatosPersonales)

        layoutPadre.addWidget(datosPersonales)

        # ====================== Sitios ====================== 

        layoutSitios = QGridLayout()

        labelFila1 = QLabel("Fila 1 |")
        labelFila2 = QLabel("Fila 2 |")
        labelFila3 = QLabel("Fila 3 |")

        self.sitio1 = QCheckBox("Sitio 1")
        self.sitio2 = QCheckBox("Sitio 2")
        self.sitio3 = QCheckBox("Sitio 3")

        self.sitio4 = QCheckBox("Sitio 4")
        self.sitio5 = QCheckBox("Sitio 5")
        self.sitio6 = QCheckBox("Sitio 6")

        self.sitio7 = QCheckBox("Sitio 7")
        self.sitio8 = QCheckBox("Sitio 8")
        self.sitio9 = QCheckBox("Sitio 9")


        self.sitio1.stateChanged.connect(self.actualizarTexto)
        self.sitio2.stateChanged.connect(self.actualizarTexto)
        self.sitio3.stateChanged.connect(self.actualizarTexto)
        self.sitio4.stateChanged.connect(self.actualizarTexto)
        self.sitio5.stateChanged.connect(self.actualizarTexto)
        self.sitio6.stateChanged.connect(self.actualizarTexto)
        self.sitio7.stateChanged.connect(self.actualizarTexto)
        self.sitio8.stateChanged.connect(self.actualizarTexto)
        self.sitio9.stateChanged.connect(self.actualizarTexto)

        layoutSitios.addWidget(labelFila1, 0, 0)
        layoutSitios.addWidget(labelFila2, 1, 0)
        layoutSitios.addWidget(labelFila3, 2, 0)

        layoutSitios.addWidget(self.sitio1, 0, 1)
        layoutSitios.addWidget(self.sitio2, 0, 2)
        layoutSitios.addWidget(self.sitio3, 0, 3)

        layoutSitios.addWidget(self.sitio4, 1, 1)
        layoutSitios.addWidget(self.sitio5, 1, 2)
        layoutSitios.addWidget(self.sitio6, 1, 3)

        layoutSitios.addWidget(self.sitio7, 2, 1)
        layoutSitios.addWidget(self.sitio8, 2, 2)
        layoutSitios.addWidget(self.sitio9, 2, 3)

        sitiosAComprar = QGroupBox()
        sitiosAComprar.setTitle("Sitios")

        sitiosAComprar.setLayout(layoutSitios)

        layoutPadre.addWidget(sitiosAComprar)

        # ====================== ComboBox pelicula ====================== 

        layoutPelicula = QHBoxLayout()

        labelPelicula = QLabel("Pelicula: ")

        self.cbPelicula = QComboBox()
        #self.cbPelicula.addItems(["Pascualadas 3", "Ciro en apuros", "La caida de hecproll"])
        self.cbPelicula.setEnabled(False)

        layoutPelicula.addWidget(labelPelicula)
        layoutPelicula.addWidget(self.cbPelicula, 1)

        layoutPadre.addLayout(layoutPelicula)

        # ====================== Texto ====================== 

        self.texto = QTextEdit()
        self.texto.setEnabled(False)
        layoutPadre.addWidget(self.texto)

        # ====================== Botones ====================== 

        layoutBotones = QHBoxLayout()

        botonReiniciar = QPushButton("Reiniciar")
        botonPagar = QPushButton("Pagar")

        botonReiniciar.pressed.connect(self.reiniciar)
        botonPagar.pressed.connect(self.pagar)

        layoutBotones.addWidget(botonReiniciar)
        layoutBotones.addWidget(botonPagar)

        layoutPadre.addLayout(layoutBotones)


        # ====================== Asignación del layout padre ====================== 

        widgetContenedor = QWidget()
        widgetContenedor.setLayout(layoutPadre)
        self.setCentralWidget(widgetContenedor)

        self.actualizarTexto()
        self.contador = 0

        self.ventanaPago = VentanaPago()
        

    def actualizarTexto(self):
        self.texto.clear()
        self.cbPelicula.clear()
        self.cbPelicula.addItem("Sin elección")

        self.texto.append("\n<===== DATOS PERSONALES =====>\n")

        if self.nombreEdit.text()!="": self.texto.append(f"Nombre: {self.nombreEdit.text()}")

        if self.edadEdit.text()!="": 
            self.texto.append(f"Edad: {self.edadEdit.text()}")
            self.cbPelicula.setEnabled(True)
            self.cbPelicula.addItem("Pascualadas 3")
            if int(self.edadEdit.text())>=18: self.cbPelicula.addItems(["Ciro en apuros", "La caida de hecproll"])
        else: 
            self.cbPelicula.setDisabled(True)

        self.texto.append("\n<===== SITIOS ESCOGIDOS =====>\n")

        self.contador = 0

        if self.sitio1.isChecked(): 
            self.texto.append("Sitio 1") 
            self.contador += 1
        if self.sitio2.isChecked(): 
            self.texto.append("Sitio 2")
            self.contador += 1
        if self.sitio3.isChecked(): 
            self.texto.append("Sitio 3")
            self.contador += 1
        if self.sitio4.isChecked(): 
            self.texto.append("Sitio 4")
            self.contador += 1
        if self.sitio5.isChecked(): 
            self.texto.append("Sitio 5")
            self.contador += 1
        if self.sitio6.isChecked(): 
            self.contador += 1
            self.texto.append("Sitio 6")
        if self.sitio7.isChecked(): 
            self.contador += 1
            self.texto.append("Sitio 7")
        if self.sitio8.isChecked(): 
            self.contador += 1
            self.texto.append("Sitio 8")
        if self.sitio9.isChecked():
            self.contador += 1
            self.texto.append("Sitio 9")


    def reiniciar(self):

        self.nombreEdit.clear()
        self.edadEdit.clear()

        self.sitio1.setChecked(False)
        self.sitio2.setChecked(False)
        self.sitio3.setChecked(False)
        self.sitio4.setChecked(False)
        self.sitio5.setChecked(False)
        self.sitio6.setChecked(False)
        self.sitio7.setChecked(False)
        self.sitio8.setChecked(False)
        self.sitio9.setChecked(False)

        self.actualizarTexto()

        

    def pagar(self):

        if self.contador==0 or self.cbPelicula.currentIndex() == 0 or self.edadEdit.text()=="0" or self.nombreEdit.text() == "":

            dlg = QMessageBox()
            dlg.setWindowTitle("Error")
            dlg.setText("Debes rellenar todos los campos y seleccionar almenos un sitio")
            dlg.setIcon(QMessageBox.Icon.Warning)
            dlg.setStandardButtons(QMessageBox.StandardButton.Ok)
            dlg.exec()

        else:

            self.ventanaPago.labelPrecio.setText(f"Precio total: {12*self.contador}$")
            self.ventanaPago.show()


        
class VentanaPago(QWidget):
    def __init__(self):
        super().__init__()

        plantilla = QVBoxLayout()

        self.labelPrecio = QLabel()

        plantilla.addWidget(self.labelPrecio)

        layoutBotonesPagar = QHBoxLayout()

        botonCancelar = QPushButton("Cancelar")

        botonCancelar.released.connect(lambda: self.hide())

        botonAceptar = QPushButton("Aceptar")

        botonAceptar.released.connect(self.aceptar)

        plantilla.addLayout(layoutBotonesPagar)

        layoutBotonesPagar.addWidget(botonCancelar)
        layoutBotonesPagar.addWidget(botonAceptar)

        self.setLayout(plantilla)

    def aceptar(self):
        dlg = QMessageBox(self)
        dlg.setWindowTitle("Confirmación de pago")
        dlg.setText(f"Estás seguro de querer pagar")
        # Si le asigno nuevos botónes los anteriores se pierden
        dlg.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No)

        # Le asigno un icono
        dlg.setIcon(QMessageBox.Icon.Information)

        # Aquí no es igual que en el QDialogButtonBox, hay que compararlo con el propio botón
        if dlg.exec() == QMessageBox.StandardButton.Yes:
            self.hide()
        


app = QApplication([])

window = MainWindow() 

window.show()

app.exec()