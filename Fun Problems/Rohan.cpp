void fillSiblingsVector(node * croot) {
    for (int i = 0; i < children.size(); i++) {
        for (int j = 0; j < children.size(); j++) {
            if (i == j) {
                continue;
            }
            children[i]->siblings.push_back(children[j]);
        }
        fillSiblingsVector(children[i]);
    }
}
