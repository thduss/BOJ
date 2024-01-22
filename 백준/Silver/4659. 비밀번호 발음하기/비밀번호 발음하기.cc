#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    while (true) {
        string word;
        cin >> word;

        if (word == "end") break;

        bool vowel = false;
        bool answer = true;

        for (int i = 0; i < word.size(); ++i) {
            // 모음 검사
            if (word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') {
                vowel = true;
            }

            // 반복 검사
            if (i + 1 < word.size() && word[i] == word[i + 1]) {
                if (word[i] != 'e' && word[i] != 'o') {
                    answer = false;
                    break;
                }
            }

            // 모음 3개 또는 자음 3개 연속
            if (i + 2 < word.size() &&
                ((word[i] == 'a' || word[i] == 'e' || word[i] == 'i' || word[i] == 'o' || word[i] == 'u') &&
                 (word[i + 1] == 'a' || word[i + 1] == 'e' || word[i + 1] == 'i' || word[i + 1] == 'o' || word[i + 1] == 'u') &&
                 (word[i + 2] == 'a' || word[i + 2] == 'e' || word[i + 2] == 'i' || word[i + 2] == 'o' || word[i + 2] == 'u'))) {
                answer = false;
                break;
            } 
            else {
                if (i + 2 < word.size() && word[i] != 'a' && word[i] != 'e' && word[i] != 'i' && word[i] != 'o' && word[i] != 'u') {
                    if (word[i + 1] != 'a' && word[i + 1] != 'e' && word[i + 1] != 'i' && word[i + 1] != 'o' && word[i + 1] != 'u') {
                        if (word[i + 2] != 'a' && word[i + 2] != 'e' && word[i + 2] != 'i' && word[i + 2] != 'o' && word[i + 2] != 'u') {
                            answer = false;
                            break;
                        }
                    }
                }
            }
        }

        if (!vowel) answer = false;

        if (answer) {
            cout << "<" << word << "> is acceptable.\n";
        } else {
            cout << "<" << word << "> is not acceptable.\n";
        }
    }

    return 0;
}
