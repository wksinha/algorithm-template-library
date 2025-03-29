#include <ctime>
#include <iostream>
#include <vector>
#include <random>

void merge_sort(int*, int, int);
void merge(int*, int, int);

int main(int argc, char** argv) {
    std::mt19937 mt(time(nullptr));

    int arr_size = std::stoi(argv[1]);
    int* arr = new int[arr_size];
    for (int i = 0; i < arr_size; i++) {
        arr[i] = mt();
    }

    merge_sort(arr, 0, arr_size);
    std::cout << arr[0] << '\n';

    return 0;
}

void merge_sort(int* arr, int start, int end) {
    int len = end - start;
    if (len < 2) {
        return;
    }

    int mid = start + (len >> 1);
    merge_sort(arr, start, mid);
    merge_sort(arr, mid, end);

    merge(arr, start, end);
}

void merge(int* arr, int start, int end) {
    int len = end - start;

    int mid = start + (len >> 1);
    int lptr = start;
    int rptr = mid;

    int* temp = new int[len];
    int tptr = 0;
    while (lptr < mid && rptr < end) {
        if (arr[lptr] < arr[rptr]) {
            temp[tptr++] = arr[lptr++];
        } else {
            temp[tptr++] = arr[rptr++];
        }
    }

    while (lptr < mid) {
        temp[tptr++] = arr[lptr++];
    }

    while (rptr < end) {
        temp[tptr++] = arr[rptr++];
    }

    for (int i = 0; i < len; i++) {
        arr[start + i] = temp[i];
    }

    delete[] temp;
}
