package Models;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private Nodo[] heap;
    private int size;

    public MaxHeap() {
        heap = new Nodo[1];
        size = 0;
    }

    public void registrar(Paciente p, int prioridad) {
        asegurarCapacidad();
        heap[size] = new Nodo(p, prioridad);
        subir(size);
        size++;
    }

    public Nodo consultarSiguiente() {
        if (size == 0) return null;
        return heap[0];
    }

    public Nodo atender() {
        if (size == 0) return null;
        Nodo raiz = heap[0];
        heap[0] = heap[size - 1];
        size--;
        bajar(0);
        return raiz;
    }

    private void asegurarCapacidad() {
        if (size == heap.length) {
            Nodo[] nuevo = new Nodo[heap.length * 2];
            System.arraycopy(heap, 0, nuevo, 0, heap.length);
            heap = nuevo;
        }
    }

    private void intercambiar(int i, int j) {
        Nodo temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void subir(int i) {
        int padre = (i - 1) / 2;
        while (i > 0 && heap[i].prioridad > heap[padre].prioridad) {
            intercambiar(i, padre);
            i = padre;
            padre = (i - 1) / 2;
        }
    }

    private void bajar(int i) {
        while (true) {
            int izq = 2 * i + 1, der = 2 * i + 2, mayor = i;

            if (izq < size && heap[izq].prioridad > heap[mayor].prioridad) mayor = izq;
            if (der < size && heap[der].prioridad > heap[mayor].prioridad) mayor = der;

            if (mayor == i) break;

            intercambiar(i, mayor);
            i = mayor;
        }
    }

    public List<Nodo> obtenerElementos() {
        List<Nodo> lista = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lista.add(heap[i]);
        }
        return lista;
    }

}
