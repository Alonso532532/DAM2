import mysql.connector
from PyQt6.QtWidgets import QMainWindow, QApplication, QMessageBox, QVBoxLayout, QTableWidget, QWidget, QTableWidgetItem, QHBoxLayout, QComboBox, QLabel


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Conectar a la BBDD")

        try:
            self.con = mysql.connector.connect( # con es el nombre de la conexion, pude ser el quequeramos
                host="localhost",
                port=3306,
                user="root",
                password="1234",
                database="capitales"
            )
        except mysql.connector.Error as error:
            print(error)


        self.contenedorPrincioal = QVBoxLayout()

        self.tabla = QTableWidget()

        self.cargardatos()

        # ============================= COMBO BOH =============================
        
        self.contenedorArriba = QHBoxLayout()

        self.labelCombo = QLabel("Selecciona una autonomía: ")

        self.combo = QComboBox()

        self.contenedorArriba.addWidget(self.labelCombo)
        self.contenedorArriba.addWidget(self.combo)
        self.contenedorPrincioal.addLayout(self.contenedorArriba)

        # ============================= TABLICA =============================

        self.contenedorPrincioal.addWidget(self.tabla)

        cosa = QWidget()
        cosa.setLayout(self.contenedorPrincioal)

        self.setCentralWidget(cosa)


        
    def cargardatos(self):
        # Creo el cursor
        cursor = self.con.cursor() 
        sql="SELECT * FROM capitales"
        
        # Ejecuto la consulta con el cursor
        cursor.execute(sql)

        # Recojo los resultados
        self.resultado=cursor.fetchall()

        # Coge los nobres de las tablas
        columnas = [desc[0] for desc in cursor.description]

        # Tamaño de la tabla
        self.tabla.setColumnCount(len(columnas))
        self.tabla.setRowCount(len(self.resultado))
        # Pone nombre a las rows
        self.tabla.setHorizontalHeaderLabels(columnas)


        for fila,registro in enumerate(self.resultado):
            for col,valor in enumerate(registro):
                texto = "" if valor is None else str(valor)
                item = QTableWidgetItem(texto)
                self.tabla.setItem(fila,col,item)






app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()
