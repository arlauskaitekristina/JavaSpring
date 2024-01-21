package spring.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import spring.models.Issuance;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает выдачу книг читателям
 */
@Repository
public class IssuanceRepository {
    private final List<Issuance> issuanceList;

    public IssuanceRepository() {
        this.issuanceList = new ArrayList<>();
    }

    @PostConstruct
    public void generateData() {
        issuanceList.addAll(List.of(
                new Issuance(2, 1),
                new Issuance(3, 4),
                new Issuance(6, 2),
                new Issuance(1, 5)
        ));
        returnBookByReader(getIssuanceById(3));
    }

    /**
     * Вывести весь список выдач книг читателям из хранилища
     *
     * @return список выдач
     */
    public List<Issuance> readIssuanceList() {
        return issuanceList;
    }

    /**
     * Вывести выдачу по ID из хранилища
     *
     * @param id идентификатор выдачи
     * @return выдачу по ID
     */
    public Issuance getIssuanceById(long id) {
        return issuanceList.stream()
                .filter(issuance -> issuance.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Получить все выдачи по ID читателя
     *
     * @param id идентификатор читателя
     * @return список выдач по ID читателя
     */
    public List<Issuance> getIssuanceListByIdReader(long id) {
        return issuanceList.stream()
                .filter(issuance -> (issuance.getReaderId() == id && issuance.getReturned_at() == null))
                .toList();
    }

    /**
     * Записать выдачу в хранилище
     *
     * @param issuance описание выдачи
     */
    public void saveIssuance(Issuance issuance) {
        issuanceList.add(issuance);
    }

    /**
     * Метод возврата книги читателем (закрытие выдачи)
     *
     * @param issuance выдача которую закрываем
     */
    public void returnBookByReader(Issuance issuance) {
        issuance.setReturned_at(LocalDateTime.now());
    }
}
