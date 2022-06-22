        public static long findPermutations(int n, List<long>  c)
        {

            // The 2-dimension buffer will contain answers to this question:
            // "how much permutations is there for an amount of `i` cents, and `j`
            // remaining coins?" eg. `buffer[10][2]` will tell us how many permutations
            // there are when giving back 10 cents using only the first two coin types
            // [ 1, 2 ].
            long[][] buffer = new long[n + 1][];
            for (var i = 0; i <= n; ++i)
                buffer[i] = new long[c.Count + 1];

            // For all the cases where we need to give back 0 cents, there's exactly
            // 1 permutation: the empty set. Note that buffer[0][0] won't ever be
            // needed.
            for (var j = 1; j <= c.Count; ++j)
                buffer[0][j] = 1;

            // We process each case: 1 cent, 2 cent, etc. up to `n` cents, included.
            for (int i = 1; i <= n; ++i)
            {

                // No more coins? No permutation is possible to attain `i` cents.
                buffer[i][0] = 0;

                // Now we consider the cases when we have J coin types available.
                for (int j = 1; j <= c.Count; ++j)
                {

                    // First, we take into account all the known permutations possible
                    // _without_ using the J-th coin (actually computed at the previous
                    // loop step).
                    var value = buffer[i][j - 1];

                    // Then, we add all the permutations possible by consuming the J-th
                    // coin itself, if we can.
                    if (c[j - 1] <= i)
                        value += buffer[i - c[j - 1]][j];

                    // We now know the answer for this specific case.
                    buffer[i][j] = value;
                }
            }

            // Return the bottom-right answer, the one we were looking for in the
            // first place.
            return buffer[n][c.Count];
        }
