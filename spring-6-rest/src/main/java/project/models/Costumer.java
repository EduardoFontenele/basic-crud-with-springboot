package project.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Costumer {
	private String costumerName;
	private UUID id;
	private Integer version;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
}
