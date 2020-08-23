/**
 * Why Trie? :-
 *
 * With Trie, we can insert and find strings in O(L) time where L represent the length of a single word.
 * This is obviously faster than BST. This is also faster than Hashing because of the ways it is implemented.
 * We do not need to compute any hash function. No collision handling is required (like we do in open addressing and separate chaining)
 * Another advantage of Trie is, we can easily print all words in alphabetical order which is not easily possible with hashing.
 * We can efficiently do prefix search (or auto-complete) with Trie.
 */
package dataStructure.trie;