
def can_partition_set(the_set: list):
    set_length = len(the_set)
    total_sum = 0
    for i in the_set:
        total_sum += i

    if total_sum % 2 != 0:
        return False

    subset_sum = total_sum // 2

    lookup_table = [[0 for i in range(subset_sum + 1)] for j in range(set_length)]

    # each set has an empty set which can satisfy sum 0
    for i in range(set_length):
        lookup_table[i][0] = True

    # for i in range(1, set_length + 1):
    #     if the_set[0] == i:
    #         lookup_table[0][i] = True

    # process all subsets for all sums
    for i in range(1, set_length):
        for j in range(1, subset_sum + 1):
            if lookup_table[i - 1][j]:
                # Case 1 of knapsack, i.e. not including this set element in sum
                lookup_table[i][j] = lookup_table[i - 1][j]
            elif j >= the_set[i]:
                # Case 2 of knapsack
                lookup_table[i][j] = lookup_table[i - 1][j - the_set[i]]

    return lookup_table[set_length - 1][subset_sum]


if __name__ == '__main__':
    a_set = [1, 2, 3, 4]
    print(can_partition_set(a_set))
    a_set = [3, 2, 4, 6]
    print(can_partition_set(a_set))
