#include <iostream>
#include <vector>
using namespace std;

void insertion(vector<int>&arr){
    int n=arr.size();
for(int i=1;i<n;i++){
int key=arr[i];
int j=i-1;
while(j>=0 && arr[j]>key){
arr[j+1]=arr[j];
j--;
}
arr[j+1]=key;
}
}

int main() {
  vector<int>nums={23,21,10,22,78,50,49};
    insertion(nums);
    for (int val : nums) {
        cout << val << " ";
    }
    return 0;
}

//Insetion sort algorithm