g++ mergesort.cc -O0 -o opt-zero
g++ mergesort.cc -O1 -o opt-one
g++ mergesort.cc -O2 -o opt-two
g++ mergesort.cc -O3 -o opt-three
g++ mergesort.cc -O3 -march=native -o opt-native

ARR_SIZE=12345678

time ./opt-zero $ARR_SIZE 1> time-zero 2> time-zero
time ./opt-one $ARR_SIZE 1> time-one 2> time-one
time ./opt-two $ARR_SIZE 1> time-two 2> time-two
time ./opt-three $ARR_SIZE 1> time-three 2> time-three
time ./opt-native $ARR_SIZE 1> time-native 2> time-native

rm opt-zero
rm opt-one
rm opt-two
rm opt-three
rm opt-native





#(time ./opt-zero $ARR_SIZE) 1> time-zero 2> time-zero
#(time ./opt-one $ARR_SIZE) 1> time-one 2> time-one
#(time ./opt-two $ARR_SIZE) 1> time-two 2> time-two
#(time ./opt-three $ARR_SIZE) 1> time-three 2> time-three
#(time ./opt-native $ARR_SIZE) 1> time-native 2> time-native
